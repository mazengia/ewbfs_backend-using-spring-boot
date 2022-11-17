package com.example.ewbfsbackend.Products;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
    @Override
    Optional<Products> findById(Long aLong);
}