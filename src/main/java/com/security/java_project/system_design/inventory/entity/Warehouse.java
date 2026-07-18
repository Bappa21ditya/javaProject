package com.security.java_project.system_design.inventory.entity;

public class Warehouse {
    private String warehouseId;
    private String warehouseName;

    private Address address;

    private Inventory inventory;

    public Warehouse(String warehouseId,
                     String warehouseName,
                     Address address) {

        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.address = address;
        this.inventory = new Inventory();
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public Address getAddress() {
        return address;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
