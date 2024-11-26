package com.mydata.curd.service;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.PageRequest; 
import org.springframework.stereotype.Service;

import com.mydata.curd.entity.Category;
import com.mydata.curd.repository.CategoryRepository;

import java.util.Optional; 
 
@Service 
public class CategoryServiceImpl implements CategoryService{ 
 
    @Autowired 
    private CategoryRepository categoryRepository; 
 
    public Page<Category> getAllCategories(int page) { 
        return categoryRepository.findAll(PageRequest.of(page, 10)); 
    } 
 
    public Category createCategory(Category category) { 
        return categoryRepository.save(category); 
    } 
 
    public Optional<Category> getCategoryById(Long id) { 
        return categoryRepository.findById(id); 
    } 
 
    public Category updateCategory(Long id, Category updatedCategory) { 
        return categoryRepository.findById(id).map(category -> { 
            category.setName(updatedCategory.getName()); 
            return categoryRepository.save(category); 
        }).orElse(null); 
    } 
 
    public void deleteCategory(Long id) { 
        categoryRepository.deleteById(id); 
    } 
}