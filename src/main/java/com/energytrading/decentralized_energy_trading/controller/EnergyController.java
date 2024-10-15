package com.energytrading.decentralized_energy_trading.controller;

import com.energytrading.decentralized_energy_trading.model.EnergyData;
import com.energytrading.decentralized_energy_trading.repository.EnergyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/energy")
public class EnergyController {

    @Autowired
    private EnergyDataRepository energyDataRepository;

    @PostMapping
    public EnergyData addEnergyData(@RequestBody EnergyData data) {
        // 设置数据的时间戳
        data.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return energyDataRepository.save(data);
    }

    @GetMapping
    public Iterable<EnergyData> getAllEnergyData() {
        return energyDataRepository.findAll();
    }
}
