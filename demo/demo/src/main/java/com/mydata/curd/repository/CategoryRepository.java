package com.mydata.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.curd.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
