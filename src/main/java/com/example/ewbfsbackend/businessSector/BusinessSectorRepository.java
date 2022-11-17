package com.example.ewbfsbackend.businessSector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessSectorRepository extends JpaRepository<Businesses, Long> {
    @Override
    Optional<Businesses> findById(Long aLong);
}