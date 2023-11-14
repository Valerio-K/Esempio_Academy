package com.sistemi.repository;

import com.sistemi.entity.Buyer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    //findAll
    //findById
    //save
    //deleteById
}
