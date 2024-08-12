package com.bookmanagement.service;

import com.bookmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.brand LIKE %:keyword% OR p.category LIKE %:keyword%")
    List<Product> searchProducts(@Param("keyword") String keyword);
}
