package com.mydata.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.curd.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
