package com.energytrading.decentralized_energy_trading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EnergyTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seller;
    private String buyer;
    private Double amount; // in kWh
    private Double price; // per kWh
    private LocalDateTime tradeTime;

    // Constructors
    public EnergyTrade() {}

    public EnergyTrade(String seller, String buyer, Double amount, Double price) {
        this.seller = seller;
        this.buyer = buyer;
        this.amount = amount;
        this.price = price;
        this.tradeTime = LocalDateTime.now();
    }

    // Getters and setters
    // ... (omitted for brevity, but you should implement these)

    @Override
    public String toString() {
        return "EnergyTrade{" +
                "id=" + id +
                ", seller='" + seller + '\'' +
                ", buyer='" + buyer + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", tradeTime=" + tradeTime +
                '}';
    }
}