package com.example.ewbfsbackend.Requests;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RequestAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    RequestsDTO updateRequest(@PathVariable long id, @RequestBody Requests requests);

    @GetMapping("/{id}")
    ResponseEntity<RequestsDTO> findRequestById(@PathVariable Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<RequestsDTO> deleteRequest(@PathVariable Long id);
    @GetMapping("/loan/{id}")
    ResponseEntity<CollectionModel<RequestsDTO>> findRequestByCustomerId(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);

    @GetMapping
    ResponseEntity<CollectionModel<RequestsDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    RequestsDTO addRequest(@RequestBody Requests requests);

}
