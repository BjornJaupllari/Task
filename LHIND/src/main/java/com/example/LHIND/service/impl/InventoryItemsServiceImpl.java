package com.example.LHIND.service.impl;

import com.example.LHIND.entity.InventoryItems;
import com.example.LHIND.repository.InventoryItemsRepository;
import com.example.LHIND.service.InventoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemsServiceImpl implements InventoryItemsService {

    @Autowired
    private InventoryItemsRepository inventoryItemsRepository;

    @Override
    public List<InventoryItems> getAllInventoryItems() {
        return inventoryItemsRepository.findAll();
    }

    @Override
    public Optional<InventoryItems> getInventoryItemsById(int id) {
        return inventoryItemsRepository.findById(id);
    }

    @Override
    public InventoryItems createInventoryItems(InventoryItems inventoryItems) {
        return inventoryItemsRepository.save(inventoryItems);
    }

    @Override
    public InventoryItems updateInventoryItems(int id, InventoryItems inventoryItemsDetails) {
        Optional<InventoryItems> optionalInventoryItems = inventoryItemsRepository.findById(id);
        if (optionalInventoryItems.isPresent()) {
            InventoryItems inventoryItems = optionalInventoryItems.get();
            inventoryItems.setName(inventoryItemsDetails.getName());
            inventoryItems.setQuantity(inventoryItemsDetails.getQuantity());
            inventoryItems.setUnityPrice(inventoryItemsDetails.getUnityPrice());
            inventoryItems.setPackageVolume(inventoryItemsDetails.getPackageVolume());
            return inventoryItemsRepository.save(inventoryItems);
        } else {
            return null;
        }
    }

    @Override
    public void deleteInventoryItems(int id) {
        inventoryItemsRepository.deleteById(id);
    }
}
