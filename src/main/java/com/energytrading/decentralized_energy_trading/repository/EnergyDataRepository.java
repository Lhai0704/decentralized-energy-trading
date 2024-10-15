package com.energytrading.decentralized_energy_trading.repository;

import com.energytrading.decentralized_energy_trading.model.EnergyData;
import org.springframework.data.repository.CrudRepository;

public interface EnergyDataRepository extends CrudRepository<EnergyData, Long> {
}
