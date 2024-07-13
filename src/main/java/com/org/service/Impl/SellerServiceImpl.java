package com.org.service.Impl;

import com.org.entity.Seller;
import com.org.model.SellerDTO;
import com.org.repository.SellerRepository;
import com.org.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Seller createSeller(SellerDTO sellerDTO) {
        if (sellerDTO != null) {
            Seller seller = new Seller();
            seller.setName(sellerDTO.getName());
            seller.setAddress(sellerDTO.getAddress());
            seller.setEmail(sellerDTO.getEmail());
            seller.setPhone(sellerDTO.getPhone());
            sellerRepository.save(seller);
            return seller;
        }
        return null;
    }

    @Override
    public SellerDTO updateSeller(Long id, SellerDTO sellerDTO) {
        Optional<Seller> buyers = sellerRepository.findById(id);
        if (buyers.isPresent()) {
            Seller seller = buyers.get();
            seller.setName(sellerDTO.getName());
            seller.setPhone(sellerDTO.getPhone());
            seller.setEmail(sellerDTO.getEmail());
            seller.setAddress(sellerDTO.getAddress());
            sellerRepository.save(seller);
            return sellerDTO;
        }
        return sellerDTO;
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    public Seller getSeller(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }


    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
}
