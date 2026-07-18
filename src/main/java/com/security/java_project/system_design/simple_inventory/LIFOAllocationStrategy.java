package com.security.java_project.system_design.simple_inventory;

public class LIFOAllocationStrategy implements AllocationStrategy{
    @Override
    public void allocate(
            InventoryItem item,
            int quantity) {

        item.reduceStock(quantity);

        System.out.println(
                "LIFO Allocation : "
                        + quantity);
    }
}
