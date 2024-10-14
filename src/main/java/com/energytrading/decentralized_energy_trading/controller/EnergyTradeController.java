package com.energytrading.decentralized_energy_trading.controller;

import com.energytrading.decentralized_energy_trading.model.EnergyTrade;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class EnergyTradeController {

    private List<EnergyTrade> trades = new ArrayList<>();

    @PostMapping
    public EnergyTrade createTrade(@RequestBody EnergyTrade trade) {
        trades.add(trade);
        return trade;
    }

    @GetMapping
    public List<EnergyTrade> getAllTrades() {
        return trades;
    }

    @GetMapping("/{id}")
    public EnergyTrade getTrade(@PathVariable int id) {
        return trades.get(id);
    }
}