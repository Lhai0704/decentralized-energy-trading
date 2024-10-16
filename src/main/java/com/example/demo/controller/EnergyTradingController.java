package com.example.demo.controller;

import com.example.demo.model.EnergyListing;
import com.example.demo.service.EnergyTradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/energy")
public class EnergyTradingController {

    private final EnergyTradingService service;

    @Autowired
    public EnergyTradingController(EnergyTradingService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public ResponseEntity<EnergyListing> listEnergy(@RequestParam String sellerId,
                                                    @RequestParam BigDecimal amount,
                                                    @RequestParam BigDecimal price) {
        EnergyListing listing = service.listEnergy(sellerId, amount, price);
        return ResponseEntity.ok(listing);
    }

    @GetMapping("/listings")
    public ResponseEntity<List<EnergyListing>> getActiveListings() {
        List<EnergyListing> listings = service.getActiveListings();
        return ResponseEntity.ok(listings);
    }

    @PostMapping("/buy")
    public ResponseEntity<Void> buyEnergy(@RequestParam Long listingId,
                                          @RequestParam String buyerId) {
        service.buyEnergy(listingId, buyerId);
        return ResponseEntity.ok().build();
    }
}