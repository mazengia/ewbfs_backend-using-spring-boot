package com.example.ewbfsbackend.businessSector;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class BusinessSectorAssembler implements RepresentationModelAssembler<Businesses, BusinessSectorDTO> {

    @Override
    public BusinessSectorDTO toModel(Businesses businesses) {
        return new BusinessSectorDTO(
                businesses.getId(),
                businesses.getName(),
                businesses.getDescription()
        );
    }
}
