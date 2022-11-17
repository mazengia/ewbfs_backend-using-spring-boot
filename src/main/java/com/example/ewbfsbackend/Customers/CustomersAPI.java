package com.example.ewbfsbackend.Customers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomersAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CustomersDTO updateCustomers(@PathVariable long id, @RequestBody Customers customers);

    @GetMapping("/{id}")
    ResponseEntity<CustomersDTO> findCustomerById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<CustomersDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    CustomersDTO addCustomers(@RequestBody Customers requests);

}
