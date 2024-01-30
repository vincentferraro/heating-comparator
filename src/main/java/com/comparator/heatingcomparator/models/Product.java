package com.comparator.heatingcomparator.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.ForeignKey;


@Data
@Entity
public class Product {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    private String designation;

    @Nonnull
    private String reference;

    @ManyToOne
    @JoinColumn(name = "supplier_id",
			foreignKey = @ForeignKey(name = "SUPPLIER_ID_FK"))
    private Supplier supplier;
    
    @Nonnull
    private String type;

    public Product(){};

    public Product(String designation, String reference, Supplier supplier, String type){
        this.designation = designation;
        this.reference = reference;
        // this.supplier = supplier;
        this.type = type;
    }

}
