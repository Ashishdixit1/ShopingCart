package com.org.service;

import com.org.entity.Buyer;
import com.org.entity.Seller;
import com.org.model.BuyerDtO;
import com.org.model.SellerDTO;

import java.util.List;

public interface SellerService {

    Seller createSeller(SellerDTO sellerDTO);

    SellerDTO updateSeller(Long id, SellerDTO sellerDTO);

    List<Seller> getAllSellers();

    public Seller getSeller(Long id);

    public void deleteSeller(Long id);
}
