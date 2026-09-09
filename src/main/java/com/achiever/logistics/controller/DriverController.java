package com.achiever.logistics.controller;

import com.achiever.logistics.entity.Driver;
import com.achiever.logistics.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "*")
public class DriverController {
    @Autowired private DriverService driverService;
    @GetMapping public List<Driver> getAllDrivers() { return driverService.getAllDrivers(); }
    @PostMapping public Driver createDriver(@RequestBody Driver driver) { return driverService.saveDriver(driver); }
    @DeleteMapping("/{id}") public void deleteDriver(@PathVariable Long id) { driverService.deleteDriver(id); }
}