package com.example.LHIND.repository;

import com.example.LHIND.entity.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemsRepository extends JpaRepository<InventoryItems, Integer> {

}
