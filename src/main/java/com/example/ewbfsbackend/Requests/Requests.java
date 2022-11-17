package com.example.ewbfsbackend.Requests;

import com.example.ewbfsbackend.Customers.Customers;
import com.example.ewbfsbackend.Products.Products;
import com.example.ewbfsbackend.businessSector.Businesses;
import com.example.ewbfsbackend.Status.Status;
import com.example.ewbfsbackend.util.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Requests extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float requested_loan_amt;
    private int no_of_year_in_business;
    private boolean have_collateral;
    private boolean fully_owned_by_business;
    private boolean able_to_pay_5_present;


    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @ManyToOne
//            (cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Businesses businesses;
}
