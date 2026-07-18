package com.security.java_project.system_design.inventory.strategy;

import com.security.java_project.system_design.inventory.entity.Product;
import com.security.java_project.system_design.inventory.entity.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseSelectionStrategy {
    Warehouse selectWarehouse(
            List<Warehouse> warehouses,
            Map<Product,Integer> products);
}
