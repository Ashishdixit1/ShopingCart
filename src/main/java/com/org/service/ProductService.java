package com.org.service;

import com.org.entity.Buyer;
import com.org.entity.Product;
import com.org.model.BuyerDtO;
import com.org.model.ProductDTO;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    List<Product> getAllProducts();

     Product getProduct(Long id);

     void deleteProduct(Long id);


}
