package com.example.ewbfsbackend.businessSector;

import com.example.ewbfsbackend.Requests.RequestsDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BusinessAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    BusinessSectorDTO updateBusinessSector(@PathVariable long id, @RequestBody Businesses businesses);

    @GetMapping("/{id}")
    ResponseEntity<BusinessSectorDTO> findBusinessSectorById(@PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<BusinessSectorDTO> deleteBusinessSector(@PathVariable Long id);
    @GetMapping
    ResponseEntity<CollectionModel<BusinessSectorDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    BusinessSectorDTO addBusinessSector(@RequestBody Businesses businesses);

}
