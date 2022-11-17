package com.example.ewbfsbackend.Products;

import org.springframework.hateoas.CollectionModel;

public interface ProductsService {
    CollectionModel<ProductsDTO> findAll(int page, int size );

    ProductsDTO addProducts(Products products);

    ProductsDTO findProductsById(Long id);
    ProductsDTO deleteCustomersById(Long id);
    ProductsDTO updateProducts(Long id,Products products);

}
