package com.example.ewbfsbackend.Customers;

import com.example.ewbfsbackend.Products.Products;
import com.example.ewbfsbackend.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import static com.example.ewbfsbackend.util.Util.getNullPropertyNames;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    CustomersRepository customersRepository;
    CustomersAssembler customersAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<CustomersDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Customers> customers = customersRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(customers.getContent()))
            return pagedResourcesAssembler.toModel(customers, customersAssembler);

        return null;
    }

    @Override
    public CustomersDTO addCustomers(Customers customers) {
        return customersAssembler.toModel(customersRepository.save(customers));
    }

    @Override
    public CustomersDTO findCustomersById(Long id) {
        Customers customers = customersRepository.findById(id).orElse(null);
        if (customers != null) {
            return customersAssembler.toModel(customers);
        }
        return null;
    }

    @Override
    public CustomersDTO deleteCustomersById(Long id) {
        customersRepository.deleteById(id);
        return null;
    }

    @Override
    public CustomersDTO updateCustomers(Long id, Customers customers) {
        Customers oldData = customersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Products.class, "Id", String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(customers, oldData, getNullPropertyNames(customers));
            return addCustomers(oldData);
        }
        return null;
    }
}
