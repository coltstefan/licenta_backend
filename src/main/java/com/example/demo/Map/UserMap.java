package com.example.demo.Map;


import com.example.demo.domains.FitnessProgramme;
import com.example.demo.domains.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserMap {

    private String email;
    private String password;
    private Set<Trainer> trainers;
    private Set<FitnessProgramme> fitnessProgrammes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Set<FitnessProgramme> getFitnessProgrammes() {
        return fitnessProgrammes;
    }

    public void setFitnessProgrammes(Set<FitnessProgramme> fitnessProgrammes) {
        this.fitnessProgrammes = fitnessProgrammes;
    }
}
