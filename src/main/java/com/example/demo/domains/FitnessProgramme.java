package com.example.demo.domains;


import com.example.demo.DemoApplication;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class FitnessProgramme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String trainingDifficulty;

    @ManyToMany(mappedBy = "fitnessProgrammes" , cascade = CascadeType.DETACH)
    @JsonBackReference
    private Set<User> userList = new HashSet<>();

    @ManyToMany(mappedBy = "fitnessProgrammes" , cascade = CascadeType.DETACH)
    @JsonBackReference
    private Set<Trainer> trainersList = new HashSet<>();


    public FitnessProgramme(String name, String trainingDifficulty) {
        this.name = name;
        this.trainingDifficulty = trainingDifficulty;
    }
}
