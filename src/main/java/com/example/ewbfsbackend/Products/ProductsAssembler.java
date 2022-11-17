package com.example.ewbfsbackend.Products;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductsAssembler implements RepresentationModelAssembler<Products, ProductsDTO> {

    @Override
    public ProductsDTO toModel(Products products) {
        return new ProductsDTO(
                products.getId(),
                products.getName(),
                products.getDescription(),
                products.getBudget()
        );
    }
}
