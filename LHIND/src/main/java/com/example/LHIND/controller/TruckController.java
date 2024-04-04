package com.example.LHIND.controller;

import com.example.LHIND.entity.Truck;
import com.example.LHIND.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping("/all")
    public ResponseEntity<List<Truck>> getAllTrucks() {
        List<Truck> trucks = truckService.getAllTrucks();
        return ResponseEntity.ok(trucks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truck> getTruckById(@PathVariable int id) {
        Optional<Truck> truck = truckService.getTruckById(id);
        return truck.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Truck> createTruck(@RequestBody Truck truck) {
        Truck createdTruck = truckService.createTruck(truck);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTruck);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteTruck(@PathVariable int id) {
        truckService.deleteTruck(id);
        return ResponseEntity.noContent().build();
    }
}
