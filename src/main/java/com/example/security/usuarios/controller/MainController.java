package com.example.security.usuarios.controller;

import java.util.List;

import com.example.security.usuarios.entity.Country;
import com.example.security.usuarios.entity.Product;
import com.example.security.usuarios.entity.User;
import com.example.security.usuarios.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    
    @Autowired
    private MainService mainService;


    @GetMapping("usuarios")
    public List<User> getAllUsers() {
        return mainService.getAllUsers();
    }

    @GetMapping("productos")
    public List<Product> getAllProducts() {
        return mainService.getAllproducts();
    }

    @GetMapping("paises")
    public List<Country> getAllCountries() {
        return mainService.getAllCountries();
    }
}
