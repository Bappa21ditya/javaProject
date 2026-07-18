package com.security.java_project.system_design.simple_inventory;

public interface StockObserver {
    void update(
            Product product,
            int stock);
}
