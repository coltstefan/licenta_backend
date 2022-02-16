package com.example.demo.services;


import com.example.demo.DemoApplication;
import com.example.demo.domains.FitnessProgramme;
import com.example.demo.repositories.FitProgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitProgServiceImpl implements FitProgService{

    private final FitProgRepository fitProgRepository;

    public FitProgServiceImpl(FitProgRepository fitProgRepository) {
        this.fitProgRepository = fitProgRepository;
    }


    @Override
    public FitnessProgramme save(FitnessProgramme fp) {
        return fitProgRepository.save(fp);
    }

    @Override
    public List<FitnessProgramme> findAll() {
        return fitProgRepository.findAll();
    }

    @Override
    public FitnessProgramme findFitnessProgrammeById(Long id) {
        return fitProgRepository.findFitnessProgrammeById(id);
    }

    @Override
    public List<FitnessProgramme> findFitnessProgrammeByTrainingDifficulty(String trainingDifficulty) {
        return fitProgRepository.findFitnessProgrammeByTrainingDifficulty(trainingDifficulty);
    }
}
