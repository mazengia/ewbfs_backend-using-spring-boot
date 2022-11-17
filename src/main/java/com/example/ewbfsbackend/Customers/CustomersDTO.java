package com.example.ewbfsbackend.Customers;

import com.example.ewbfsbackend.model.Branches;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomersDTO extends RepresentationModel<CustomersDTO> {
    private final Long id;
    private String full_name;
    private String phone;
    private LocalDateTime age;
    private String education;
    private String nationality;
    private boolean valid_trade_license;
    private String branches;

}
