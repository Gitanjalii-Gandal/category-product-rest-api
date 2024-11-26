package com.mydata.curd.service;


 
import org.springframework.data.domain.Page;

import com.mydata.curd.entity.Product;

import java.util.Optional; 
 
public interface ProductService { 
 
    Page<Product> getAllProducts(int page); 
 
    Product createProduct(Product product); 
 
    Optional<Product> getProductById(Long id); 
 
    Product updateProduct(Long id, Product updatedProduct); 
 
    void deleteProduct(Long id); 
}