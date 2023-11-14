package com.sistemi.service;

import com.sistemi.entity.Buyer;
import com.sistemi.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyerService implements BuyerServiceI {

    @Autowired
    private BuyerRepository repo;

    @Override
    public List<Buyer> findAllBuyers() {
        return repo.findAll();
    }

    @Override
    public Buyer findBuyerById(Integer vatNumber) {
        return repo.findById(vatNumber).orElseThrow();
    }

    @Override
    public Buyer saveOrUpdateBuyer(Buyer buyer) {
        return repo.save(buyer);
    }

    @Override
    public Map<String, Boolean> deleteBuyer(Integer vatNumber) {
        Map<String, Boolean> deletionMap = new HashMap<>();
        try {
            repo.deleteById(vatNumber);
            if (repo.existsById(vatNumber)) {
                deletionMap.put("exist", true);
            } else {
                deletionMap.put("exist", false);
            }
        } catch(IllegalArgumentException ex) {
            deletionMap.put("deletion", false);
        }
        return deletionMap;
    }
}
