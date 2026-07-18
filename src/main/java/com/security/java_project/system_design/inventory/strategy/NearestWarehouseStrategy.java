package com.security.java_project.system_design.inventory.strategy;

import com.security.java_project.system_design.inventory.entity.Product;
import com.security.java_project.system_design.inventory.entity.Warehouse;

import java.util.List;
import java.util.Map;

public class NearestWarehouseStrategy implements WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(
            List<Warehouse> warehouses,
            Map<Product,Integer> products) {

        if(warehouses.isEmpty()) {

            throw new RuntimeException(
                    "No warehouse available");
        }

        return warehouses.get(0);
    }
}
