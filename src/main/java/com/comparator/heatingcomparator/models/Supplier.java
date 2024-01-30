package com.comparator.heatingcomparator.models;

import java.util.ArrayList;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "supplier")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    public Supplier(){
    }

    public Supplier(String name, String location){
        this.name = name;
        this.location = location;
    }


}
