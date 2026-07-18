package com.security.java_project.system_design.inventory.repos;

import com.security.java_project.system_design.inventory.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private final Map<String, Product>
            products =
            new HashMap<>();

    public void save(
            Product product) {

        products.put(
                product.getProductId(),
                product);
    }

    public Product findById(
            String productId) {

        return products.get(
                productId);
    }

    public List<Product> findAll() {

        return new ArrayList<>(
                products.values());
    }

    public void delete(
            String productId) {

        products.remove(
                productId);
    }
}
