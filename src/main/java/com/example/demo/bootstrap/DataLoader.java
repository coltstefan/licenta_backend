package com.example.demo.bootstrap;

import com.example.demo.DemoApplication;
import com.example.demo.domains.Exercise;
import com.example.demo.domains.FitnessProgramme;
import com.example.demo.domains.Trainer;
import com.example.demo.domains.User;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.FitProgService;
import com.example.demo.services.TrainerService;
import com.example.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ExerciseService exerciseService;
    private final UserService userService;
    private final TrainerService trainerService;
    private final FitProgService fitProgService;

    public DataLoader(ExerciseService exerciseService, UserService userService, TrainerService trainerService, FitProgService fitProgService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
        this.trainerService = trainerService;
        this.fitProgService = fitProgService;
    }


    @Override
    public void run(String... args) throws Exception {

        Exercise exercise1 = new Exercise("Genoflexiuni","Flexeaza genunchii",15,10,"image1", "CHEST");
        exerciseService.save(exercise1);

        Exercise exercise2 = new Exercise("Genoflexiuni1","Flexeaza genunchii",15,10,"image1", "CHEST");
        exerciseService.save(exercise2);



        User user1 = new User("user1@gmail.com","parola");


        User user2 = new User("user2@gmail.com","parola");



        Trainer trainer1 = new Trainer("trainer1@gmail.com","parola" , "Stefan" , "Colt");
       // trainerService.save(trainer1);

        Trainer trainer2 = new Trainer("trainer2@gmail.com","parola" , "Stefan" , "Colt");
      //  trainerService.save(trainer2);

        FitnessProgramme fitnessProgramme1 = new FitnessProgramme("fitProg1" , "Hardcore");
        FitnessProgramme fitnessProgramme2 = new FitnessProgramme("fitProg2" , "Medium");
        FitnessProgramme fitnessProgramme3 = new FitnessProgramme("fitProg3" , "Beginner");
        FitnessProgramme fitnessProgramme4 = new FitnessProgramme("fitProg4" , "Cardio");

        user1.addFitnessProgramme(fitnessProgramme1);
        user1.addFitnessProgramme(fitnessProgramme2);

        user2.addFitnessProgramme(fitnessProgramme2);
        user2.addFitnessProgramme(fitnessProgramme3);
        user2.addFitnessProgramme(fitnessProgramme4);

        trainer1.addFitnessProgramme(fitnessProgramme1);
        trainer1.addFitnessProgramme(fitnessProgramme2);
        trainer1.addFitnessProgramme(fitnessProgramme3);

        trainer2.addFitnessProgramme(fitnessProgramme3);
        trainer2.addFitnessProgramme(fitnessProgramme4);


        fitProgService.save(fitnessProgramme1);
        fitProgService.save(fitnessProgramme2);
        fitProgService.save(fitnessProgramme3);
        fitProgService.save(fitnessProgramme4);

        userService.save(user1);
        userService.save(user2);

        trainer1.addClient(user1);
        trainer2.addClient(user2);

        trainerService.save(trainer1);
        trainerService.save(trainer2);





    }
}