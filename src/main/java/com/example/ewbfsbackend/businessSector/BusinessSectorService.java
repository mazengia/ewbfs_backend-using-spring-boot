package com.example.ewbfsbackend.businessSector;

import com.example.ewbfsbackend.Requests.RequestsDTO;
import org.springframework.hateoas.CollectionModel;

public interface BusinessSectorService {
    CollectionModel<BusinessSectorDTO> findAll(int page, int size );

    BusinessSectorDTO addBusinessSector(Businesses businesses);

    BusinessSectorDTO deleteBusinessSectorById(Long id);
    BusinessSectorDTO findBusinessSectorById(Long id);
    BusinessSectorDTO updateCustomers(Long id, Businesses businesses);
}
