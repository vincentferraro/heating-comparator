package com.comparator.heatingcomparator.models;

import java.util.ArrayList;

import java.util.List;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.CascadeType;

@Data
@Entity(name = "supplier")
public class Supplier {
    
    @Id
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private String location;

    public Supplier(){
    }

    public Supplier(String name, String location, List<Product> products){
        this.name = name;
        this.location = location;
    }


}
