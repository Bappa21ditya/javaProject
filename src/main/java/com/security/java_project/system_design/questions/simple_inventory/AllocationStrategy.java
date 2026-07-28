package com.security.java_project.system_design.questions.simple_inventory;

public interface AllocationStrategy {
    void allocate(
            InventoryItem item,
            int quantity);
}
