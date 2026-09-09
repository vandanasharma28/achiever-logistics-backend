package com.achiever.logistics.controller;

import com.achiever.logistics.entity.Vehicle;
import com.achiever.logistics.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {
    @Autowired private VehicleService vehicleService;
    @GetMapping public List<Vehicle> getAllVehicles() { return vehicleService.getAllVehicles(); }
    @PostMapping public Vehicle createVehicle(@RequestBody Vehicle vehicle) { return vehicleService.saveVehicle(vehicle); }
    @DeleteMapping("/{id}") public void deleteVehicle(@PathVariable Long id) { vehicleService.deleteVehicle(id); }
}