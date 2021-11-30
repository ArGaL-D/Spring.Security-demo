package com.example.security.usuarios.service;

import java.util.List;

import com.example.security.usuarios.entity.Product;
import com.example.security.usuarios.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    // GET 

    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }
}
