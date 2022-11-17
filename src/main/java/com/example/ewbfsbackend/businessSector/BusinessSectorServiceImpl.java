package com.example.ewbfsbackend.businessSector;

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
public class BusinessSectorServiceImpl implements BusinessSectorService {

    BusinessSectorRepository businessSectorRepository;
    BusinessSectorAssembler businessSectorAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<BusinessSectorDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Businesses> businessSectors = businessSectorRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(businessSectors.getContent()))
            return pagedResourcesAssembler.toModel(businessSectors, businessSectorAssembler);

        return null;
    }

    @Override
    public BusinessSectorDTO addBusinessSector(Businesses businesses) {
        return businessSectorAssembler.toModel(businessSectorRepository.save(businesses));
    }

    @Override
    public BusinessSectorDTO deleteBusinessSectorById(Long id) {
        businessSectorRepository.deleteById(id);
        return null;

    }

    @Override
    public BusinessSectorDTO findBusinessSectorById(Long id) {
        Businesses businesses = businessSectorRepository.findById(id).orElse(null);
        if (businesses != null) {
            return businessSectorAssembler.toModel(businesses);
        }
        return null;
    }

    @Override
    public BusinessSectorDTO updateCustomers(Long id, Businesses businesses) {
        Businesses oldData = businessSectorRepository.findById(id).orElseThrow(()->new EntityNotFoundException(Products.class,"Id",String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(businesses,oldData,getNullPropertyNames(businesses));
            return  addBusinessSector(oldData);
        }
        return null;
    }
}
