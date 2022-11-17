package com.example.ewbfsbackend.Status;

import com.example.ewbfsbackend.Products.Products;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class StatusAssembler implements RepresentationModelAssembler<Status, StatusDTO> {

    @Override
    public StatusDTO toModel(Status status) {
        return new StatusDTO(
                status.getId(),
                status.getName(),
                status.getDescription()
        );
    }
}
