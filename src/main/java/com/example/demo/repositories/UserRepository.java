package com.example.demo.repositories;

import com.example.demo.domains.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("select u from User u")
    List<User> findAll();

    @Query("select u from User u where u.email = :email")
    User findByEmail(String email);

    @Query("select u from User u where u.id = :id")
    User findUserById(Long id);






}
