package com.example.demo.services;

import com.example.demo.domains.Trainer;
import com.example.demo.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer findTrainerById(Long id) {
        return trainerRepository.findTrainerById(id);
    }

    @Override
    public Trainer findByEmail(String email) {
        return trainerRepository.findByEmail(email);
    }

    @Override
    public Trainer findByFirstName(String firstName) {
        return trainerRepository.findTrainerByFirstName(firstName);
    }

    @Override
    public Trainer findByLastName(String lastName) {
        return trainerRepository.findTrainerByLastName(lastName);
    }
}
