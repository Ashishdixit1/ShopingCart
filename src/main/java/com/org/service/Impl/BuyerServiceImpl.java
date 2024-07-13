package com.org.service.Impl;

import com.org.entity.Buyer;
import com.org.model.BuyerDtO;
import com.org.repository.BuyerRepository;
import com.org.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public Buyer createBuyer(BuyerDtO buyerDTO) {
        if (buyerDTO != null) {
            Buyer buyer = new Buyer();
            buyer.setName(buyerDTO.getName());
            buyer.setAddress(buyerDTO.getAddress());
            buyer.setEmail(buyerDTO.getEmail());
            buyer.setPhone(buyerDTO.getPhone());
            buyerRepository.save(buyer);
            return buyer;
        }
        return null;
    }

    @Override
    public BuyerDtO updateBuyer(Integer id, BuyerDtO buyerDtO) {
        Optional<Buyer> buyers = buyerRepository.findById(id);
        if (buyers.isPresent()) {
            Buyer buyer = buyers.get();
            buyer.setName(buyerDtO.getName());
            buyer.setPhone(buyerDtO.getPhone());
            buyer.setEmail(buyerDtO.getEmail());
            buyer.setAddress(buyerDtO.getAddress());
            buyerRepository.save(buyer);
            return buyerDtO;
        }
        return buyerDtO;
    }

    public void deleteBuyer(Integer id) {
        buyerRepository.deleteById(id);
    }

    public Buyer getBuyer(Integer id) {
        return buyerRepository.findById(id).orElse(null);
    }


    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }
}
