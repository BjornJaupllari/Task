package com.example.LHIND.service;

import com.example.LHIND.entity.Truck;

import java.util.List;
import java.util.Optional;

public interface TruckService {
    List<Truck> getAllTrucks();

    Optional<Truck> getTruckById(int id);

    Truck createTruck(Truck truck);

    void deleteTruck(int id);
}
