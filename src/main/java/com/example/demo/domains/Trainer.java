package com.example.demo.domains;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"clientsList","fitnessProgrammes"})
@NoArgsConstructor
@ToString
@Table(name = "Trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;



    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="clients_trainers",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="trainer_id"))
    @JsonManagedReference
    private java.util.Set<User> clientsList = new HashSet<>();

    public void addClient(User u){
        clientsList.add(u);
        u.getTrainers().add(this);
    }

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="traineri_programe",
            joinColumns = @JoinColumn(name="trainer_id"),
            inverseJoinColumns = @JoinColumn(name="fitnessProgramme_id"))
    @JsonManagedReference
    private Set<FitnessProgramme> fitnessProgrammes = new HashSet<>();



    public Trainer(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void addFitnessProgramme(FitnessProgramme fp){
        fitnessProgrammes.add(fp);
        fp.getTrainersList().add(this);
    }


}
