package com.example.productinventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.productinventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods
    List<Product> findByPriceBetween(Double min, Double max);
    List<Product> findByQuantityLessThan(Integer qty);
}
