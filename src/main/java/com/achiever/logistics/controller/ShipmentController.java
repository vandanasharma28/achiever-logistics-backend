package com.achiever.logistics.controller;

import com.achiever.logistics.entity.Shipment;
import com.achiever.logistics.repository.ShipmentRepository;
import com.achiever.logistics.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shipments")
@CrossOrigin(origins = "*")
public class ShipmentController {
    @Autowired private ShipmentService shipmentService;
    @Autowired private ShipmentRepository shipmentRepository;

    @GetMapping
    public List<Map<String, Object>> getAllShipments() {
        List<Shipment> list = shipmentService.getAllShipments();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Shipment s : list) {
            Map<String, Object> m = new HashMap<>();
            m.put("id", s.getId());
            m.put("lrNumber", s.getLrNumber());
            m.put("origin", s.getOrigin());
            m.put("destination", s.getDestination());
            m.put("status", s.getStatus() != null ? s.getStatus().toString() : "PENDING");
            m.put("createdAt", s.getCreatedAt());
            result.add(m);
        }
        return result;
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.saveShipment(shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }

}