package com.example.ewbfsbackend.Requests;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {
    @Override
    Optional<Requests> findById(Long aLong);
    Page<Requests> findRequestsByCustomersId(PageRequest pageRequest, Long id);
}