package com.example.ewbfsbackend.businessSector;

import org.springframework.hateoas.CollectionModel;

public interface BusinessSectorService {
    CollectionModel<BusinessSectorDTO> findAll(int page, int size );

    BusinessSectorDTO addBusinessSector(Businesses businesses);

    BusinessSectorDTO findBusinessSectorById(Long id);
    BusinessSectorDTO updateCustomers(Long id, Businesses businesses);
}
