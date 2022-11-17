package com.example.ewbfsbackend.Requests;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/requests")
public class RequestsController implements RequestAPI {
    RequestsService requestsService;

    public RequestsController(RequestsService requestsService) {
        this.requestsService = requestsService;
    }


    @Override
    public RequestsDTO updateRequest(long id, Requests requests) {
        return requestsService.updateRequests(id, requests);
    }

    @Override
    public ResponseEntity<RequestsDTO> findRequestById(Long id) {
        RequestsDTO requestsDTO = requestsService.findRequestsById(id);
        if (requestsDTO != null) return ResponseEntity.ok(requestsDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RequestsDTO> deleteRequest(Long id) {
        RequestsDTO requestsDTO = requestsService.deleteRequestsById(id);
        if (requestsDTO != null) return ResponseEntity.ok(requestsDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<RequestsDTO>> findRequestByCustomerId(Long id, Integer page, Integer size) {

        CollectionModel<RequestsDTO> requestsDTOS = requestsService.findRequestsByCustomerId(page, size,id);
        if (requestsDTOS != null)
            return ResponseEntity.ok(requestsDTOS);
        return ResponseEntity.noContent().build();
    }



    @Override
    public ResponseEntity<CollectionModel<RequestsDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<RequestsDTO> requestsDTOS = requestsService.findAll(page, size);
            if (requestsDTOS != null)
                return ResponseEntity.ok(requestsDTOS);
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public RequestsDTO addRequest(Requests requests) {
        return requestsService.addRequests(requests);
    }
}
