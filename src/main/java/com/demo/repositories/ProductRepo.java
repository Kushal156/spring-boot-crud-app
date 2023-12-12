package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
