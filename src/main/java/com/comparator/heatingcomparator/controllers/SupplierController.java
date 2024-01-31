package com.comparator.heatingcomparator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comparator.heatingcomparator.models.Supplier;
import com.comparator.heatingcomparator.repositories.SupplierRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<Iterable<Supplier>> getAllSuppliers() {
        Iterable<Supplier> supplier =supplierRepo.findAll();
        if(supplier != null){
            ResponseEntity.status(HttpStatus.OK).body(supplier);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Supplier>> getSupplierByName(@PathVariable("name") String name) {
        Optional<Supplier> supplier = supplierRepo.findByName(name);
        if(supplier != null){
            return ResponseEntity.status(HttpStatus.OK).body(supplier);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        try{
            if(supplier.getName() == null || supplier.getLocation() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("missing input(s)");
            }
            supplierRepo.save(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).body("supplier added successfully");
        }catch(Exception exc){
            log.info("Error"+exc.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable("id") Integer id){
        try{
            if(id != null){
                supplierRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch(Exception exc){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    
}
