package com.example.productinventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.productinventory.model.Product;
import com.example.productinventory.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product with ID " + id + " deleted successfully!";
    }

    // Custom endpoints
    @GetMapping("/price-range")
    public List<Product> getByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return productService.getProductsByPriceRange(min, max);
    }

    @GetMapping("/low-stock")
    public List<Product> getLowStock(@RequestParam Integer limit) {
        return productService.getLowStockProducts(limit);
    }
}
