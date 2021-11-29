package com.example.security.usuarios.repository;

import com.example.security.usuarios.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends JpaRepository<Country, Long>{
    
}
