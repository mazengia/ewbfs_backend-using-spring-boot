package com.example.ewbfsbackend.Customers;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CustomersAssembler implements RepresentationModelAssembler<Customers, CustomersDTO> {

    @Override
    public CustomersDTO toModel(Customers customers) {
        return new CustomersDTO(
                customers.getId(),
                customers.getFull_name(),
                customers.getPhone(),
                customers.getAge(),
                customers.getEducation(),
                customers.getNationality(),
                true,
                customers.getBranches()
        );
    }
}
