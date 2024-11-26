package com.mydata.curd.service;

import com.mydata.curd.entity.Category;
import org.springframework.data.domain.Page; 
import java.util.Optional; 

public interface CategoryService {

	
	 Page<Category> getAllCategories(int page); 
	    Category createCategory(Category category); 
	    Optional<Category> getCategoryById(Long id); 
	    Category updateCategory(Long id, Category updatedCategory); 
	    void deleteCategory(Long id); 
}
