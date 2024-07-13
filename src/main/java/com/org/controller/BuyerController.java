package com.org.controller;

import com.org.entity.Buyer;
import com.org.model.BuyerDtO;
import com.org.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @PostMapping("/buyer")
    public Buyer crateBuyer(@RequestBody BuyerDtO buyerDtO) {
        return buyerService.createBuyer(buyerDtO);
    }


    @GetMapping("/buyers")
    public List<Buyer> getBuyers() {
        List<Buyer> buyers = buyerService.getAllBuyers();
        return buyers;
    }

    @PutMapping("/buyer/{id}")
    public BuyerDtO updateBuyer(@PathVariable Integer id, @RequestBody BuyerDtO buyerDtO) {
        return buyerService.updateBuyer(id, buyerDtO);
    }

    @DeleteMapping("/buyer/{id}")
    String deleteBuyer(@PathVariable Integer id) {
        buyerService.deleteBuyer(id);
        return "Deleted";

    }

    @GetMapping("/buyer/{id}")
    public Buyer getBuyer(@PathVariable Integer id) {
        return buyerService.getBuyer(id);
    }


}
