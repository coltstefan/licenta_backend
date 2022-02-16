package com.example.demo.domains;


import com.example.demo.DemoApplication;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private int repetitions;

    private int minutes;

    private String image;


    private String exerciseType;


    public Exercise(String name, String description, int repetitions, int minutes, String image, String exerciseType) {
        this.name = name;
        this.description = description;
        this.repetitions = repetitions;
        this.minutes = minutes;
        this.image = image;
        this.exerciseType = exerciseType;
    }
}
