package com.energytrading.decentralized_energy_trading.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnergyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double energyProduced;
    private String deviceId;
    private String timestamp;

    public EnergyData() {
    }

    public EnergyData(double energyProduced, String deviceId, String timestamp) {
        this.energyProduced = energyProduced;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getEnergyProduced() {
        return energyProduced;
    }

    public void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}