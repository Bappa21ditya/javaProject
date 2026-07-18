package com.security.java_project.system_design.simple_inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private static final InventoryManager INSTANCE =
            new InventoryManager();

    private InventoryManager() {
    }

    public static InventoryManager
    getInstance() {
        return INSTANCE;
    }

    private final Map<String, InventoryItem>
            inventory =
            new ConcurrentHashMap<>();

    private final List<StockObserver>
            observers =
            new ArrayList<>();

    private AllocationStrategy strategy;


    public void setStrategy(
            AllocationStrategy strategy) {

        this.strategy = strategy;
    }

    public void addObserver(
            StockObserver observer) {
        observers.add(observer);
    }

    public void addProduct(
            Product product,
            int stock) {

        inventory.put(
                product.getProductId(),
                new InventoryItem(
                        product,
                        stock));
    }
    public void addStock(
            String productId,
            int quantity) {

        InventoryItem item =
                inventory.get(productId);

        if(item != null) {
            item.addStock(quantity);
        }
    }

    public void removeStock(
            String productId,
            int quantity) {

        InventoryItem item =
                inventory.get(productId);

        strategy.allocate(
                item,
                quantity);

        if(item.getStock() < 10) {

            notifyObservers(item);
        }
    }





    private void notifyObservers(
            InventoryItem item) {

        for(StockObserver observer :
                observers) {

            observer.update(
                    item.getProduct(),
                    item.getStock());
        }
    }

    public void printInventory() {

        System.out.println(
                "\n===== INVENTORY =====");

        inventory.values()
                .forEach(item ->
                        System.out.println(
                                item.getProduct()
                                        .getName()
                                        + " -> "
                                        + item.getStock()));
    }
}
