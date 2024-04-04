package com.example.LHIND.controller;

import com.example.LHIND.entity.InventoryItems;
import com.example.LHIND.service.InventoryItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory-items")
public class InventoryItemsController {

    @Autowired
    private InventoryItemsService inventoryItemsService;

    @GetMapping
    public ResponseEntity<List<InventoryItems>> getAllInventoryItems() {
        List<InventoryItems> inventoryItemsList = inventoryItemsService.getAllInventoryItems();
        return new ResponseEntity<>(inventoryItemsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItems> getInventoryItemsById(@PathVariable("id") int id) {
        Optional<InventoryItems> inventoryItems = inventoryItemsService.getInventoryItemsById(id);
        return inventoryItems.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<InventoryItems> createInventoryItems(@RequestBody InventoryItems inventoryItems) {
        InventoryItems createdItem = inventoryItemsService.createInventoryItems(inventoryItems);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventoryItems> updateInventoryItems(@PathVariable("id") int id, @RequestBody InventoryItems inventoryItemsDetails) {
        InventoryItems updatedItem = inventoryItemsService.updateInventoryItems(id, inventoryItemsDetails);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventoryItems(@PathVariable("id") int id) {
        inventoryItemsService.deleteInventoryItems(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
