package com.example.LHIND.service.impl;

import com.example.LHIND.entity.Truck;
import com.example.LHIND.repository.TruckRepository;
import com.example.LHIND.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckRepository truckRepository;

    @Override
    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    @Override
    public Optional<Truck> getTruckById(int id) {
        return truckRepository.findById(id);
    }

    @Override
    public Truck createTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    @Override
    public void deleteTruck(int id) {
        truckRepository.deleteById(id);
    }
}
