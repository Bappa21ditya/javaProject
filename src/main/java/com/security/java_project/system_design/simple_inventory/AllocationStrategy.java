package com.security.java_project.system_design.simple_inventory;

public interface AllocationStrategy {
    void allocate(
            InventoryItem item,
            int quantity);
}
