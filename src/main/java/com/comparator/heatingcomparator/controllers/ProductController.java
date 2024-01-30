package com.comparator.heatingcomparator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comparator.heatingcomparator.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comparator.heatingcomparator.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping(path="/products")
public class ProductController {
    
    @Autowired
    ProductRepository productRepo ;

    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        try{

            Iterable<Product> product = productRepo.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(product);

        }catch(Exception exc){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{reference}")
    public ResponseEntity<Optional<Product>> getProductByReference(@PathVariable("reference") String reference) {
        try{
            Optional<Product> product = productRepo.findByReference(reference);
            if(!product.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch(Exception exc){
            log.info(exc.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try{
            if(product == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("missing input(s)");
            }
            productRepo.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
        }catch(IllegalArgumentException exc){   
            log.info(exc.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        try{
            if(id == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("missing id");
            }
            
            Optional<Product> product = productRepo.findById(id);
            if(!product.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
            }
            productRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception exc){
            log.info(exc.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    

}
