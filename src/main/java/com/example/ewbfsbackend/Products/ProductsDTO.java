package com.example.ewbfsbackend.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProductsDTO extends RepresentationModel<ProductsDTO> {
    private final Long id;
    private String name;
    private String description;
    private  String budget;

}
