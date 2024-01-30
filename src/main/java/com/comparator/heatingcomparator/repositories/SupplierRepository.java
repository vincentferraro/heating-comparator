package com.comparator.heatingcomparator.repositories;

import org.springframework.data.repository.CrudRepository;
import com.comparator.heatingcomparator.models.Supplier;

import java.util.Optional;


public interface SupplierRepository extends CrudRepository<Supplier, Long>{
    public Optional<Supplier> findByName(String name);

}
