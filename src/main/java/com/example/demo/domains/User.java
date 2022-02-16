package com.example.demo.domains;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Clienti")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;


    @ManyToMany(mappedBy = "clientsList", cascade = CascadeType.DETACH )
    //@JsonBackReference
    private Set<Trainer> trainers = new HashSet<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="clienti_programe",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="fitnessProgramme_id"))
    //@JsonManagedReference
    private Set<FitnessProgramme> fitnessProgrammes = new HashSet<>();


    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public void addFitnessProgramme(FitnessProgramme fp){
        fitnessProgrammes.add(fp);
        fp.getUserList().add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }


}
