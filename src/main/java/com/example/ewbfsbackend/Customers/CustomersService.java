package com.example.ewbfsbackend.Customers;


import org.springframework.hateoas.CollectionModel;

public interface CustomersService {
    CollectionModel<CustomersDTO> findAll(int page, int size);

    CustomersDTO addCustomers(Customers customers);

    CustomersDTO findCustomersById(Long id);
    CustomersDTO deleteCustomersById(Long id);

    CustomersDTO updateCustomers(Long id, Customers customers);
}
