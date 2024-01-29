package com.comparator.heatingcomparator.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.comparator.heatingcomparator.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

    Optional<Product> findByReference(String reference);
}
