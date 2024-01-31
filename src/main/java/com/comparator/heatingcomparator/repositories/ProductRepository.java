package com.comparator.heatingcomparator.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.comparator.heatingcomparator.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

    Optional<Product> findByReference(String reference);

    @Query("SELECT p from product p WHERE p.name LIKE ?name")
    Optional<Product> searchByName(String name);

}
