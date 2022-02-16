package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.domains.Exercise;

import java.util.List;

public interface ExerciseService {

    Exercise save(Exercise exercise);
    List<Exercise> findAll();
    List<Exercise> findByExerciseType(String exerciseType);

}
