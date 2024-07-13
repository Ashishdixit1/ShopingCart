package com.org.service.Impl;

import com.org.entity.Product;
import com.org.entity.Seller;
import com.org.model.ProductDTO;
import com.org.repository.ProductRepository;
import com.org.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {
        if (productDTO != null) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            Seller seller = new Seller();
            seller.setId(productDTO.getSellerId());
            product.setSeller(seller);
            productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> products = productRepository.findById(id);
        if (products.isPresent()) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            productRepository.save(product);
            return productDTO;
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
