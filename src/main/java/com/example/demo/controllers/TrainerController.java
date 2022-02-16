package com.example.demo.controllers;


import com.example.demo.domains.Trainer;
import com.example.demo.domains.User;
import com.example.demo.services.TrainerService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;


    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping
    private List<Trainer> getTrainers(){
        return trainerService.findAll();
    }

    @GetMapping("email/{email}")
    private Trainer geTrainerByEmail(@PathVariable(value = "email") String email){
        return trainerService.findByEmail(email);}

    @GetMapping("/{id}")
    private Trainer getTrainerById(@PathVariable(value = "id") Long id){
        return trainerService.findTrainerById(id);
    }

    @GetMapping("/{id}/clients")
    private Set<User> getClients(@PathVariable(value = "id") Long id){
        return trainerService.findTrainerById(id).getClientsList();
    }


}
