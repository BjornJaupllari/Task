package com.example.LHIND.service;

import com.example.LHIND.entity.InventoryItems;

import java.util.List;
import java.util.Optional;

public interface InventoryItemsService {
    List<InventoryItems> getAllInventoryItems();

    Optional<InventoryItems> getInventoryItemsById(int id);

    InventoryItems createInventoryItems(InventoryItems inventoryItems);

    InventoryItems updateInventoryItems(int id, InventoryItems inventoryItemsDetails);

    void deleteInventoryItems(int id);
}
