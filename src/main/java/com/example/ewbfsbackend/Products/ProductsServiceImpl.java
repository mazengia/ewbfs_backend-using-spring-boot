package com.example.ewbfsbackend.Products;

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
public class ProductsServiceImpl implements ProductsService {

    ProductsRepository productsRepository;
    ProductsAssembler productsAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<ProductsDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Products> products = productsRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(products.getContent()))
            return pagedResourcesAssembler.toModel(products, productsAssembler);

        return null;
    }

    @Override
    public ProductsDTO addProducts(Products products) {
        return productsAssembler.toModel(productsRepository.save(products));
    }

    @Override
    public ProductsDTO findProductsById(Long id) {
        Products products = productsRepository.findById(id).orElseThrow(()->new EntityNotFoundException(Products.class,"Id",String.valueOf(id)));
        if (products != null) {
            return productsAssembler.toModel(products);
        }
        return null;
    }

    @Override
    public ProductsDTO deleteCustomersById(Long id) {
        productsRepository.deleteById(id);
        return null;
    }

    @Override
    public ProductsDTO updateProducts(Long id, Products products) {
        Products oldData = productsRepository.findById(id).orElseThrow(()->new EntityNotFoundException(Products.class,"Id",String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(products,oldData,getNullPropertyNames(products));
            return  addProducts(oldData);
        }
        return null;
    }



}
