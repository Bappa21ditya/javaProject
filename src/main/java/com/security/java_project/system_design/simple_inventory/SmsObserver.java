package com.security.java_project.system_design.simple_inventory;

public class SmsObserver implements StockObserver{
    @Override
    public void update(
            Product product,
            int stock) {

        System.out.println(
                "SMS ALERT : "
                        + product.getName()
                        + " stock = "
                        + stock);
    }
}
