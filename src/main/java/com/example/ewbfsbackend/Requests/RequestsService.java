package com.example.ewbfsbackend.Requests;

import org.springframework.hateoas.CollectionModel;

import java.util.List;

public interface RequestsService {
    CollectionModel<RequestsDTO> findAll(int page, int size );

    RequestsDTO addRequests(Requests requests);

    RequestsDTO findRequestsById(Long id);
    RequestsDTO deleteRequestsById(Long id);
    RequestsDTO updateRequests(Long id, Requests requests);

    CollectionModel<RequestsDTO> findRequestsByCustomerId(int page, int size ,Long id);
}
