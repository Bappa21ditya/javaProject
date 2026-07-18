package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.entity.Warehouse;
import com.security.java_project.system_design.inventory.repos.WarehouseRepository;

import java.util.List;

public class WarehouseService {

    private final WarehouseRepository repository;

    public WarehouseService(
            WarehouseRepository repository) {

        this.repository = repository;
    }

    public void addWarehouse(
            Warehouse warehouse) {

        repository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return repository.findAll();
    }
}
