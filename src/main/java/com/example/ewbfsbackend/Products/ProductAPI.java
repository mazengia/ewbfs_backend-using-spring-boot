package com.example.ewbfsbackend.Products;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProductAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ProductsDTO updateProduct(@PathVariable long id, @RequestBody Products products);

    @GetMapping("/{id}")
    ResponseEntity<ProductsDTO> findProductsId(@PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<ProductsDTO> deleteCustomer(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<ProductsDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
     ProductsDTO addProducts(@RequestBody Products products);

}
