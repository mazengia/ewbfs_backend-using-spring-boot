package com.example.ewbfsbackend.Customers;


import com.example.ewbfsbackend.util.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Customers extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    private String phone;
    private LocalDateTime age;
    private String education;
    private String nationality;
    private boolean valid_trade_license;
    private String branches;
}
