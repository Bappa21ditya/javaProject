package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.entity.Product;
import com.security.java_project.system_design.inventory.repos.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId);
    }
}
