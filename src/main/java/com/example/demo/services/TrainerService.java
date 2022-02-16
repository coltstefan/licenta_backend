package com.example.demo.services;


import com.example.demo.domains.Trainer;

import java.util.List;

public interface TrainerService {

    Trainer save(Trainer trainer);
    List<Trainer> findAll();
    Trainer findTrainerById(Long id);
    Trainer findByEmail(String email);
    Trainer findByFirstName(String firstName);
    Trainer findByLastName(String lastName);


}

