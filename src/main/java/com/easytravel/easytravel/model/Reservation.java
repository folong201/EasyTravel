package com.easytravel.easytravel.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



// import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;

// import com.fasterxml.jackson.annotation.JsonTypeInfo.*;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "user")
    // private User user;
    @Column(name = "nbPlace")
    private int nbPlace;
    @Column(name = "etat")
    @NotNull(message = "l'etat ne peut pas etre initialiser a null")
    private String etat;
    
    //cette relation permet de preciser qu'une reservation appartien a un seul voyage
    @ManyToOne
    @OnDelete(action =OnDeleteAction.CASCADE)
    private Travel travel;

    //ici on precise qu'un utilisateur peut avoir plusieur reservation    
    // @OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Travel.class)
    // private List<Reservation> reservations;
    
    @ManyToOne
    @OnDelete(action =OnDeleteAction.CASCADE)
    private User user;

    public void setTravel(Travel travel2) {
        this.travel = travel2;
    }
}
