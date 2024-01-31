package com.comparator.heatingcomparator.services;

import com.comparator.heatingcomparator.repositories.ProductRepository;
import com.comparator.heatingcomparator.repositories.SupplierRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.comparator.heatingcomparator.models.Product;
import com.comparator.heatingcomparator.models.Supplier;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductManagementImpl {
    
    private final ProductRepository productRepo;
    private final SupplierRepository supplierRepo;

    ProductManagementImpl(ProductRepository productRepo, SupplierRepository supplierRepo){
        this.productRepo = productRepo;
        this.supplierRepo = supplierRepo;
    }

    @Transactional
    public void changeProductFromSupplier(Integer ProductId, Integer SupplierId)throws Exception{
                log.info("ChangeProducFromSupplier");
                if(ProductId == null || SupplierId == null) throw new Exception("missing id(s)");
                log.info("here2");
                Product product = productRepo.findById(ProductId).orElse(null);
                log.info("here3");
                Supplier supplier = supplierRepo.findById(SupplierId).orElse(null);
                log.info("PRODUCT:"+ product.toString()+" ; Supplier"+ supplier.toString());
                if(product == null || supplier == null) throw new Exception("product or supplier not found");
                product.setSupplier(supplier);
                productRepo.save(product);
    }
}
