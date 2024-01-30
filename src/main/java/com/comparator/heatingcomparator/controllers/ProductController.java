package com.comparator.heatingcomparator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comparator.heatingcomparator.repositories.ProductRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comparator.heatingcomparator.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path="/products")
public class ProductController {
    
    @Autowired
    ProductRepository productRepo ;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{reference}")
    public Optional<Product> getProductByReference(@PathVariable("reference") String reference) {
        return productRepo.findByReference(reference);
    }
    
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        
        try{
            if(product != null){
                productRepo.save(product);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
        }catch(IllegalArgumentException exc){   
            
            return ResponseEntity.badRequest().body("field missing");

        }
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id){
        try{
            if(id != null){
                Optional<Product> product = productRepo.findById(id);
                if(product.isPresent()){
                    productRepo.deleteById(id);
                }
            }
            
        }catch(Exception e){}
    }

    

}
