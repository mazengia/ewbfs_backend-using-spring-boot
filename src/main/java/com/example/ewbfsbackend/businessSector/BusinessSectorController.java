package com.example.ewbfsbackend.businessSector;

import com.example.ewbfsbackend.Requests.RequestsDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/business")
public class BusinessSectorController implements BusinessAPI {

    BusinessSectorService businessSectorService;

    public BusinessSectorController(BusinessSectorService businessSectorService) {
        this.businessSectorService = businessSectorService;
    }

    @Override
    public BusinessSectorDTO updateBusinessSector(long id, Businesses businesses) {
        return businessSectorService.updateCustomers(id, businesses);
    }

    @Override
    public ResponseEntity<BusinessSectorDTO> findBusinessSectorById(Long id) {
        BusinessSectorDTO businessSectorDTO = businessSectorService.findBusinessSectorById(id);
        if (businessSectorDTO != null) return ResponseEntity.ok(businessSectorDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<BusinessSectorDTO> deleteBusinessSector(Long id) {
        BusinessSectorDTO businessSectorDTO = businessSectorService.deleteBusinessSectorById(id);
        if (businessSectorDTO != null) return ResponseEntity.ok(businessSectorDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<BusinessSectorDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<BusinessSectorDTO> businessSectorDTOS = businessSectorService.findAll(page, size);
            if (businessSectorDTOS != null)
                return ResponseEntity.ok(businessSectorDTOS);
            return ResponseEntity.noContent().build();
        }
    }


    @Override
    public BusinessSectorDTO addBusinessSector(Businesses businesses) {
        return businessSectorService.addBusinessSector(businesses);
    }
}
