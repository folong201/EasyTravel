package com.easytravel.easytravel.model;


import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Agences")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "directorId")
    private Long directorId;

    // @OneToMany(targetEntity = Travel.class,cascade = CascadeType.ALL)
    // @JoinColumn(name = "travel_id",referencedColumnName = "id")
    // @OneToMany(mappedBy = "agence",cascade = CascadeType.ALL)
    // @JoinColumn(name = "aganece_id",referencedColumnName = "agence")
    // private List<Travel> travels;
    
    public Agence(Long id) {
        this.directorId = id;
    }
    public Agence(Long directorId,String name) {
        this.name = name;
        this.directorId = directorId;
    }

    public Long getDirectorId(){
        return this.directorId;
    }
     
    //ces deux ligne de codes me generent de nombreuses erreurs.
    // @OneToMany(mappedBy = "Agence",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Travel.class)
    // private List<Travel> Travels;
        



}
