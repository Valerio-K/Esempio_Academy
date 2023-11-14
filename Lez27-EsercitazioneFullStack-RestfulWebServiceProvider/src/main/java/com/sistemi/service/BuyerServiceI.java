package com.sistemi.service;

import com.sistemi.entity.Buyer;

import java.util.List;
import java.util.Map;

public interface BuyerServiceI {

    public List<Buyer> findAllBuyers();

    public Buyer findBuyerById(Integer vatNumber);

    public Buyer saveOrUpdateBuyer(Buyer buyer);

    public Map<String, Boolean> deleteBuyer(Integer vatNumber);
}
