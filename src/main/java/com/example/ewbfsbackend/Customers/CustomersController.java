package com.example.ewbfsbackend.Customers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomersController  implements CustomersAPI {
    CustomersService customersService;

    public CustomersController(CustomersService customersService ) {
        this.customersService = customersService;
    }


    @Override
    public CustomersDTO updateCustomers(long id, Customers customers) {
        return customersService.updateCustomers(id, customers);
    }

    @Override
    public ResponseEntity<CustomersDTO> findCustomerById(Long id) {
        CustomersDTO customersDTO = customersService.findCustomersById(id);
        if (customersDTO != null) return ResponseEntity.ok(customersDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CustomersDTO> deleteCustomer(Long id) {
        CustomersDTO customersDTO = customersService.deleteCustomersById(id);
        if (customersDTO != null) return ResponseEntity.ok(customersDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<CustomersDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<CustomersDTO> customersDTOS = customersService.findAll(page, size);
            if (customersDTOS != null)
                return ResponseEntity.ok(customersDTOS);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public CustomersDTO addCustomers(Customers customers) {
        return customersService.addCustomers(customers);
    }
}
