package com.example.demo.controllers;

import com.example.demo.DemoApplication;
import com.example.demo.domains.FitnessProgramme;
import com.example.demo.services.FitProgService;
import com.example.demo.services.TrainerService;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/fitnessProgramme")
public class FitnessProgrammeController {

    private final FitProgService fitProgService;
    private final UserService userService;
    private final TrainerService trainerService;

    public FitnessProgrammeController(FitProgService fitProgService, UserService userService, TrainerService trainerService) {
        this.fitProgService = fitProgService;
        this.userService = userService;
        this.trainerService = trainerService;
    }

    @GetMapping
    private List<FitnessProgramme> getAllProgrammes(){
        return fitProgService.findAll();
    }

    @GetMapping("/{id}")
    private FitnessProgramme getProgrammeById(@PathVariable(value = "id") Long id){
        return fitProgService.findFitnessProgrammeById(id);
    }

    @GetMapping("/client/{user_id}")
    private Set<FitnessProgramme> getAllProgrammesforUser(@PathVariable(value = "user_id") Long id){
        return userService.findUserById(id).getFitnessProgrammes();
    }

    @GetMapping("/trainer/{trainer_id}")
    private Set<FitnessProgramme> getAllProgrammesforTrainer(@PathVariable(value = "trainer_id") Long id){
        return trainerService.findTrainerById(id).getFitnessProgrammes();
    }

    @GetMapping("difficulty/{diff}")
    private List<FitnessProgramme> getProgrammesByDifficulty(@PathVariable(value = "diff") String trainingDifficulty) {
        return fitProgService.findFitnessProgrammeByTrainingDifficulty(trainingDifficulty);
    }


}
