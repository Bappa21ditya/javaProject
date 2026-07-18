package com.security.java_project.system_design.simple_inventory;

public class EmailObserver implements StockObserver{
    @Override
    public void update(
            Product product,
            int stock) {

        System.out.println(
                "EMAIL ALERT : "
                        + product.getName()
                        + " stock = "
                        + stock);
    }
}
