package com.example.demo.repositories;

import com.example.demo.domains.Trainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends CrudRepository<Trainer,Long> {

    @Query("select t from Trainer t")
    List<Trainer> findAll();

    @Query("select t from Trainer t where t.id = :id")
    Trainer findTrainerById(Long id);

    @Query("select t from Trainer t where t.email = :email")
    Trainer findByEmail(String email);

    @Query("select t from Trainer t where t.firstName = :firstName")
    Trainer findTrainerByFirstName(String firstName);

    @Query("select t from Trainer t where t.lastName = :lastName")
    Trainer findTrainerByLastName(String lastName);


}
