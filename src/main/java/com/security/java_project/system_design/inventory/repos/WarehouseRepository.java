package com.security.java_project.system_design.inventory.repos;

import com.security.java_project.system_design.inventory.entity.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseRepository {
    private final Map<String, Warehouse>
            warehouses =
            new HashMap<>();

    public void save(
            Warehouse warehouse) {

        warehouses.put(
                warehouse.getWarehouseId(),
                warehouse);
    }

    public Warehouse findById(
            String warehouseId) {

        return warehouses.get(
                warehouseId);
    }

    public List<Warehouse> findAll() {

        return new ArrayList<>(
                warehouses.values());
    }

    public void delete(
            String warehouseId) {

        warehouses.remove(
                warehouseId);
    }
}
