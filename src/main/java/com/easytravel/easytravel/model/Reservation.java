package com.easytravel.easytravel.model;

// import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;

// import com.fasterxml.jackson.annotation.JsonTypeInfo.*;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user")
    private User user;
    @Column(name = "travel")
    private String travel;
    @Column(name = "nbPlace")
    private int nbPlace;
    @Column(name = "etat")
    @NotNull(message = "l'etat ne peut pas etre initialiser a null")
    // @DefaultValue(value = "en attente")
    private String etat;

}
