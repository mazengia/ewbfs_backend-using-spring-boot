package com.example.ewbfsbackend.businessSector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class BusinessSectorDTO extends RepresentationModel<BusinessSectorDTO> {
    private final Long id;
    private String name;
    private String description;

}
