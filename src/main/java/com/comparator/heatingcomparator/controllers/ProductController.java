package com.comparator.heatingcomparator.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comparator.heatingcomparator.repositories.ProductRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comparator.heatingcomparator.models.Product;


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
    
    

}
