package com.security.java_project.system_design.MyList.inventory.service;

import com.security.java_project.system_design.MyList.inventory.entity.Warehouse;
import com.security.java_project.system_design.MyList.inventory.repos.WarehouseRepository;

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
