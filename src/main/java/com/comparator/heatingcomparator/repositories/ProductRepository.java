package com.comparator.heatingcomparator.repositories;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.comparator.heatingcomparator.models.Product;
import java.util.List;
public interface ProductRepository extends CrudRepository<Product, Integer>{

    Optional<Product> findByReference(String reference);

    List<Product> findByDesignationStartsWith(String designation);

}
