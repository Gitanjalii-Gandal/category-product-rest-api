package com.mydata.curd.controller;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import com.mydata.curd.entity.Category;
import com.mydata.curd.service.CategoryService; 
 
@RestController 
@RequestMapping("/api/categories") 
public class CategoryController { 
 
   CategoryService categoryService; 
   
    public CategoryController(CategoryService categoryService) {
	super();
	this.categoryService = categoryService;
}

	@GetMapping 
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) { 
        return categoryService.getAllCategories(page); 
    } 
 
    @PostMapping 
    public Category createCategory(@RequestBody Category category) { 
        return categoryService.createCategory(category); 
    } 
 
    @GetMapping("/{id}") 
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) { 
        return categoryService.getCategoryById(id) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    } 
 
    @PutMapping("/{id}") 
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) { 
        return ResponseEntity.ok(categoryService.updateCategory(id, category)); 
    } 
 
    @DeleteMapping("/{id}") 
    public void deleteCategory(@PathVariable Long id) { 
        categoryService.deleteCategory(id); 
    } 
}