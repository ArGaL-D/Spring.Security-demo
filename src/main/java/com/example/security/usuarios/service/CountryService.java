package com.example.security.usuarios.service;

import java.util.List;

import com.example.security.usuarios.entity.Country;
import com.example.security.usuarios.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;

    // GET 

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
}
