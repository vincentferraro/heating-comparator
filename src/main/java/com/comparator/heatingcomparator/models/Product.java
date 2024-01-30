package com.comparator.heatingcomparator.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
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
    private Integer id;

    @Column(nullable=false)
    private String designation;

    @Column(nullable=false)
    private String reference;

    @ManyToOne
    @JoinColumn(name = "supplier_id",
			foreignKey = @ForeignKey(name = "id"))
    private Supplier supplier;
    
    @Column(nullable=false)
    private String type;

    public Product(){};

    public Product(String designation, String reference, Supplier supplier, String type){
        this.designation = designation;
        this.reference = reference;
        // this.supplier = supplier;
        this.type = type;
    }

}
