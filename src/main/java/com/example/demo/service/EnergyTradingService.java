package com.example.demo.service;


import com.example.demo.model.EnergyListing;
import com.example.demo.repository.EnergyListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EnergyTradingService {

    private final EnergyListingRepository repository;

    @Autowired
    public EnergyTradingService(EnergyListingRepository repository) {
        this.repository = repository;
    }

    public EnergyListing listEnergy(String sellerId, BigDecimal amount, BigDecimal price) {
        EnergyListing listing = new EnergyListing();
        listing.setSellerId(sellerId);
        listing.setAmount(amount);
        listing.setPrice(price);
        return repository.save(listing);
    }

    public List<EnergyListing> getActiveListings() {
        return repository.findByActiveTrue();
    }

    @Transactional
    public void buyEnergy(Long listingId, String buyerId) {
        EnergyListing listing = repository.findById(listingId)
                .orElseThrow(() -> new RuntimeException("Listing not found"));

        if (!listing.isActive()) {
            throw new RuntimeException("Listing is not active");
        }

        // 在这里实现购买逻辑，例如更新listing状态，创建交易记录等
        listing.setActive(false);
        repository.save(listing);

        // TODO: 实现与区块链的交互，记录交易
    }
}
