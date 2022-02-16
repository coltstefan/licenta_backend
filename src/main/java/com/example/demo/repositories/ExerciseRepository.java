package com.example.demo.repositories;


import com.example.demo.DemoApplication;
import com.example.demo.domains.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise,Long> {

    @Query("select e from Exercise e")
    List<Exercise> findAll();

    @Query("select e from Exercise e where e.exerciseType = :exerciseType")
    List<Exercise> findByExerciseType(String exerciseType);

}
