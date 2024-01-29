package com.comparator.heatingcomparator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private String reference;
    private String supplier;
    private String type;

    public Product(){};

    public Product(String designation, String reference, String supplier, String type){
        this.designation = designation;
        this.reference = reference;
        this.supplier = supplier;
        this.type = type;
    }

}
