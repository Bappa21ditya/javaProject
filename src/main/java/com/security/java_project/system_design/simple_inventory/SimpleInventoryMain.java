package com.security.java_project.system_design.simple_inventory;

public class SimpleInventoryMain {
    public static void main(String[] args) {

        Product laptop =
                ProductFactory.createProduct(
                        "P1",
                        "MacBook");

        Product mobile =
                ProductFactory.createProduct(
                        "P2",
                        "iPhone");

        InventoryManager manager =
                InventoryManager.getInstance();

        manager.setStrategy(
                new FIFOAllocationStrategy());

        manager.addObserver(
                new EmailObserver());

        manager.addObserver(
                new SmsObserver());

        manager.addProduct(
                laptop,
                50);

        manager.addProduct(
                mobile,
                20);

        manager.printInventory();

        manager.addStock(
                "P1",
                30);

        manager.printInventory();

        manager.removeStock(
                "P1",
                75);

        manager.printInventory();
    }
}
