package com.example.security.usuarios.service;

import java.util.List;

import com.example.security.usuarios.entity.User;
import com.example.security.usuarios.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // GET

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST

    public void addUser(User user) {
        userRepository.save(user);
    }

    // DELETE

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
