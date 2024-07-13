package com.org.controller;

import com.org.entity.Product;
import com.org.entity.Seller;
import com.org.model.SellerDTO;
import com.org.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/seller")
    public Seller crateSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.createSeller(sellerDTO);
    }


    @GetMapping("/sellers")
    public List<Seller> getSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return sellers;
    }

    @PutMapping("/seller/{id}")
    public SellerDTO updateSeller(@PathVariable Long id, @RequestBody SellerDTO sellerDTO) {
        return sellerService.updateSeller(id, sellerDTO);
    }

    @DeleteMapping("/seller/{id}")
    String deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return "Deleted";
    }

    @GetMapping("/seller/{id}")
    public Seller getSeller(@PathVariable Long id) {
        return sellerService.getSeller(id);
    }
}
