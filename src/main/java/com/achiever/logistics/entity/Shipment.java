package com.achiever.logistics.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String lrNumber;
    private String origin;
    private String destination;
    private String description;
    private Double weight;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
    @ManyToOne @JoinColumn(name = "driver_id") private Driver driver;
    @ManyToOne @JoinColumn(name = "vehicle_id") private Vehicle vehicle;
    @ManyToOne @JoinColumn(name = "customer_id") private Customer customer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) status = ShipmentStatus.PENDING;
    }
    @PreUpdate public void preUpdate() { updatedAt = LocalDateTime.now(); }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getLrNumber() { return lrNumber; } public void setLrNumber(String v) { this.lrNumber = v; }
    public String getOrigin() { return origin; } public void setOrigin(String v) { this.origin = v; }
    public String getDestination() { return destination; } public void setDestination(String v) { this.destination = v; }
    public String getDescription() { return description; } public void setDescription(String v) { this.description = v; }
    public Double getWeight() { return weight; } public void setWeight(Double v) { this.weight = v; }
    public ShipmentStatus getStatus() { return status; } public void setStatus(ShipmentStatus v) { this.status = v; }
    public Driver getDriver() { return driver; } public void setDriver(Driver v) { this.driver = v; }
    public Vehicle getVehicle() { return vehicle; } public void setVehicle(Vehicle v) { this.vehicle = v; }
    public Customer getCustomer() { return customer; } public void setCustomer(Customer v) { this.customer = v; }
    public LocalDateTime getCreatedAt() { return createdAt; } public void setCreatedAt(LocalDateTime v) { this.createdAt = v; }
    public LocalDateTime getUpdatedAt() { return updatedAt; } public void setUpdatedAt(LocalDateTime v) { this.updatedAt = v; }
}