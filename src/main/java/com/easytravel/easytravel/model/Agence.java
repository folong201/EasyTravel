package com.easytravel.easytravel.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private int directorId;
    public Agence(int id) {
        this.directorId = id;
    }
    public Agence(int directorId,String name) {
        this.name = name;
        this.directorId = directorId;
    }
    // public Agence(Optional<User> user) {
        
    // }
    // // public Agence(){}
    // // public void setName(String name){
    // //     this.name = name;
    // // }
    // // public String GetName(){
    // //     return this.director.getFirstName();
    // // }
    // // public void setDirector(Optional<User> user) {
    // //     this.directorId 
    // // }

}
