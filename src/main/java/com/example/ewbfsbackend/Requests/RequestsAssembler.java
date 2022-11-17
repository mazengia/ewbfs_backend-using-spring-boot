package com.example.ewbfsbackend.Requests;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestsAssembler implements RepresentationModelAssembler<Requests, RequestsDTO> {

    @Override
    public RequestsDTO toModel(Requests requests) {
        return new RequestsDTO(
                requests.getId(),
                requests.getRequested_loan_amt(),
                requests.getNo_of_year_in_business(),
                requests.isHave_collateral(),
                requests.isFully_owned_by_business(),
                requests.isAble_to_pay_5_present(),
                requests.getStatus(),
                requests.getRemark(),
                requests.getCreated_by(),
                requests.getUpdated_by(),
                requests.getCustomers(),
                requests.getProducts(),
                requests.getBusinesses()
        );
    }


}
