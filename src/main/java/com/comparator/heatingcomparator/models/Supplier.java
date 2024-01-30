package com.comparator.heatingcomparator.models;

import java.util.ArrayList;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
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
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private String location;

    public Supplier(){
    }

    public Supplier(String name, String location){
        this.name = name;
        this.location = location;
    }


}
