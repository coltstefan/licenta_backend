package com.example.demo.services;

import com.example.demo.domains.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    User findByEmail(String email);
    User findUserById(Long id);


}
