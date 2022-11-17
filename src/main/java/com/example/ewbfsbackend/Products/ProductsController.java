package com.example.ewbfsbackend.Products;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductsController implements ProductAPI {
    ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @Override
    public ProductsDTO updateProduct(long id, Products products) {
        return productsService.updateProducts(id, products);
    }

    @Override
    public ResponseEntity<ProductsDTO> findProductsId(Long id) {
        ProductsDTO productsDTO = productsService.findProductsById(id);
        if (productsDTO != null) return ResponseEntity.ok(productsDTO);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<ProductsDTO> deleteCustomer(Long id) {
        ProductsDTO productsDTO = productsService.deleteCustomersById(id);
        if (productsDTO != null) return ResponseEntity.ok(productsDTO);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<CollectionModel<ProductsDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<ProductsDTO> productsDTOS = productsService.findAll(page, size);
            if (productsDTOS != null)
                return ResponseEntity.ok(productsDTOS);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ProductsDTO addProducts(Products products) {
        return productsService.addProducts(products);
    }
}
