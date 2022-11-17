package com.example.ewbfsbackend.Products;

import com.example.ewbfsbackend.util.Auditable;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
//@EqualsAndHashCode(exclude = {"department"})
public class Products extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String description;
    private  String budget;
}
