package com.comparator.heatingcomparator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comparator.heatingcomparator.models.Supplier;
import com.comparator.heatingcomparator.repositories.SupplierRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping(path="/supplier")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepo;

    @GetMapping
    public Iterable<Supplier> getAllSuppliers() {
        try{
           Iterable<Supplier> supplier =supplierRepo.findAll();
            log.info(supplier.toString());
            return supplier;
        }catch(Exception e){
            log.info(e.getStackTrace().toString());
            return null;
        }
        
    }

    @GetMapping("/{id}")
    public Optional<Supplier> getSupplierByName(@PathVariable("id") String name) {
        return supplierRepo.findByName(name);
    }

    @PostMapping
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        
        try{
            if(supplier != null){
                supplierRepo.save(supplier);
            }
            return ResponseEntity.ok().body("supplier added successfully");
        }catch(IllegalArgumentException exc){
            return ResponseEntity.badRequest().body("missing input(s)");
        }
        
        
    }
    
    
}
