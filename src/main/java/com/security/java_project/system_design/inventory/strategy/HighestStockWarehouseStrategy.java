package com.security.java_project.system_design.inventory.strategy;

import com.security.java_project.system_design.inventory.entity.Product;
import com.security.java_project.system_design.inventory.entity.Warehouse;

import java.util.List;
import java.util.Map;

public class HighestStockWarehouseStrategy implements WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(
            List<Warehouse> warehouses,
            Map<Product,Integer> products) {

        Warehouse selected;
        selected = null;

        int maxStock = -1;

        for(Warehouse warehouse : warehouses) {

            int totalStock = 0;

            for(Product product :
                    products.keySet()) {

                totalStock +=
                        warehouse.getInventory()
                                .getStock(
                                        product.getProductId());
            }

            if(totalStock > maxStock) {

                maxStock = totalStock;
                selected = warehouse;
            }
        }

        return selected;
    }
}
