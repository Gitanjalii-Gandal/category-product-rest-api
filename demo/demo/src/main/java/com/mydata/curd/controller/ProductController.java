package com.mydata.curd.controller;
 

import org.springframework.data.domain.Page; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import com.mydata.curd.entity.Product;
import com.mydata.curd.service.ProductService; 
 
@RestController 
@RequestMapping("/api/products") 
public class ProductController { 
 
     ProductService productService; 
     
    public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping 
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) { 
        return productService.getAllProducts(page); 
    } 
 
    @PostMapping 
    public Product createProduct(@RequestBody Product product) { 
        return productService.createProduct(product); 
    } 
 
    @GetMapping("/{id}") 
    public ResponseEntity<Product> getProductById(@PathVariable Long id) { 
        return productService.getProductById(id) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    } 
 
    @PutMapping("/{id}") 
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) { 
        return ResponseEntity.ok(productService.updateProduct(id, product)); 
    } 
 
    @DeleteMapping("/{id}") 
    public void deleteProduct(@PathVariable Long id) { 
        productService.deleteProduct(id); 
    } 
}