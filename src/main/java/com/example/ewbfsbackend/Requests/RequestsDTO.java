package com.example.ewbfsbackend.Requests;

import com.example.ewbfsbackend.Customers.Customers;
import com.example.ewbfsbackend.Products.Products;
import com.example.ewbfsbackend.businessSector.Businesses;
import com.example.ewbfsbackend.Status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RequestsDTO extends RepresentationModel<RequestsDTO> {
    private final Long id;
    private float requested_loan_amt;
    private int no_of_year_in_business;
    private boolean have_collateral;
    private boolean fully_owned_by_business;
    private boolean able_to_pay_5_present;
    private Status status;
    private String remark;
    private String created_by;
    private String updated_by;
    private Customers customers;
    private Products products;
    private Businesses businesses;

}
