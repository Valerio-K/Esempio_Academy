package com.sistemi.controller;

import com.sistemi.entity.Buyer;
import com.sistemi.service.BuyerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rest/api/buyer")
public class BuyerController {

    @Autowired
    private BuyerServiceI serv;

    //http://localhost:9090/rest/api/buyer {GET}
    @GetMapping
    public List<Buyer> getBuyers() { return serv.findAllBuyers(); }

    //http://localhost:9090/rest/api/buyer/vatNumber/{vatNumber} {GET}
    @GetMapping("/vatNumber/{vatNumber}")
    public Buyer getBuyerByVatNumber(@PathVariable Integer vatNumber) { return serv.findBuyerById(vatNumber); }

    //http://localhost:9090/rest/api/buyer {POST}
    @PostMapping
    public Buyer postBuyers(@RequestBody Buyer buyer) { return serv.saveOrUpdateBuyer(buyer); }

    //http://localhost:9090/rest/api/buyer {PUT}
    @PutMapping
    public Buyer putBuyer(@RequestBody Buyer buyer) { return serv.saveOrUpdateBuyer(buyer); }

    //http://localhost:9090/rest/api/buyer/vatNumber/{vatNumber} {DELETE}
    @DeleteMapping("/vatNumber/{vatNumber}")
    public Map<String, Boolean> deleteBuyer(@PathVariable Integer vatNumber) { return serv.deleteBuyer(vatNumber); }
}
