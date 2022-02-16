package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.domains.FitnessProgramme;

import java.util.List;

public interface FitProgService {

    FitnessProgramme save(FitnessProgramme fp);
    List<FitnessProgramme> findAll();
    FitnessProgramme findFitnessProgrammeById(Long id);
    List<FitnessProgramme> findFitnessProgrammeByTrainingDifficulty(String trainingDifficulty);

}
