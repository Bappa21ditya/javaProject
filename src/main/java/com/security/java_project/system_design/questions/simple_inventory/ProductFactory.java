package com.security.java_project.system_design.questions.simple_inventory;

public class ProductFactory {

    public static  Product createProduct(String productId,String name)
    {
        return new Product(productId, name);
    }
}
