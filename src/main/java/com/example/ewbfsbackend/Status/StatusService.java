package com.example.ewbfsbackend.Status;

import org.springframework.hateoas.CollectionModel;

public interface StatusService {
    CollectionModel<StatusDTO> findAll(int page, int size );

    StatusDTO addStatus(Status status);

    StatusDTO findStatusById(Long id);
    StatusDTO updateStatus(Long id, Status status);

    StatusDTO deleteCustomersById(Long id);
}
