package com.org.service;

import com.org.entity.Buyer;
import com.org.model.BuyerDtO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuyerService {
    Buyer createBuyer(BuyerDtO buyerDTO);

    BuyerDtO updateBuyer(Integer id, BuyerDtO buyerDtO);

    List<Buyer> getAllBuyers();

    public Buyer getBuyer(Integer id);

    public void deleteBuyer(Integer id);
}
