package com.easytravel.easytravel.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Travels")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Travels")
public class Travel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "depart")
    private String depart;
    @Column(name = "destination")
    private String destination;
    @Column(name = "date")
    private String date; 
    @Column(name = "heure")
    private String heure;
    @Column(name = "agenceid")
    private int agenceid;
    @Column(name = "tarif")
    private double Tarif;
    @Column(name = "bus")
    private String bus;

    @ManyToOne
    @OnDelete(action =OnDeleteAction.CASCADE)
    private Agence Agence;

    //ici on  precise qu'un voyage a plusieur reservations
    // @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Reservation.class)
    //     private List<Reservation> reservations;
}
