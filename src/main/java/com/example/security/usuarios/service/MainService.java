package com.example.security.usuarios.service;

import java.util.List;

import com.example.security.usuarios.entity.Country;
import com.example.security.usuarios.entity.Product;
import com.example.security.usuarios.entity.User;
import com.example.security.usuarios.repository.CountryRepository;
import com.example.security.usuarios.repository.ProductRepository;
import com.example.security.usuarios.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CountryRepository countryRepository;

    /*
        GET
    */

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Product> getAllproducts() {
        return productRepository.findAll();
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
