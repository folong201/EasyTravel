package com.easytravel.easytravel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@Table(name = "travels")
public class Travel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
   @Column(name = "depart")
    private String depart;
    @Column(name = "destination")
    private String destination;
    @Column(name = "date")
    private String date; 
    @Column(name = "heure")
    private String heure;
    @Column(name = "agence")
    private int agenceId;
    @Column(name = "tarif")
    private double Tarif;
    @Column(name = "bus")
    private String bus;

}
