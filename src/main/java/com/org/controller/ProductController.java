package com.org.controller;


import com.org.entity.Order;
import com.org.entity.Product;
import com.org.model.ProductDTO;
import com.org.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public Product crateProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }


    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/product/{id}")
    String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Deleted";
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
