package com.example.demo.repositories;

import com.example.demo.DemoApplication;
import com.example.demo.domains.FitnessProgramme;
import com.example.demo.domains.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FitProgRepository extends CrudRepository<FitnessProgramme,Long> {

    @Query("select f from FitnessProgramme f")
    List<FitnessProgramme> findAll();

    @Query("select f from FitnessProgramme f where f.id = :id")
    FitnessProgramme findFitnessProgrammeById(Long id);

    @Query("select f from FitnessProgramme f where f.trainingDifficulty = :trainingDifficulty")
    List<FitnessProgramme>findFitnessProgrammeByTrainingDifficulty(String trainingDifficulty);


}
