package com.example.demo.services;

import com.example.demo.DemoApplication;
import com.example.demo.domains.Exercise;
import com.example.demo.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise save(Exercise exercise){ return exerciseRepository.save(exercise); }

    @Override
    public List<Exercise> findAll(){ return exerciseRepository.findAll(); }

    @Override
    public List<Exercise> findByExerciseType(String exerciseType){

        return exerciseRepository.findByExerciseType(exerciseType);

    }



}
