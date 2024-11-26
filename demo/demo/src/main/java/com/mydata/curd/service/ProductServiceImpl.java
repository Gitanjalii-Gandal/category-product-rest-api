package com.mydata.curd.service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.PageRequest; 
import org.springframework.stereotype.Service;

import com.mydata.curd.entity.Product;
import com.mydata.curd.repository.ProductRepository;

import java.util.Optional; 
 
@Service 
public class ProductServiceImpl implements ProductService{ 
 
    @Autowired 
    private ProductRepository productRepository; 
 
    public Page<Product> getAllProducts(int page) { 
        return productRepository.findAll(PageRequest.of(page, 10)); 
    } 
 
    public Product createProduct(Product product) { 
        return productRepository.save(product); 
    } 
 
    public Optional<Product> getProductById(Long id) { 
        return productRepository.findById(id); 
    } 
 
    public Product updateProduct(Long id, Product updatedProduct) { 
        return productRepository.findById(id).map(product -> { 
            product.setName(updatedProduct.getName()); 
            product.setPrice(updatedProduct.getPrice()); 
            product.setCategory(updatedProduct.getCategory()); 
            return productRepository.save(product); 
        }).orElse(null); 
    } 
 
    public void deleteProduct(Long id) { 
        productRepository.deleteById(id); 
    } 
}