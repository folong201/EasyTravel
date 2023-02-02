package com.easytravel.easytravel.model;


// import java.util.List;
// import java.util.Set;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToMany;
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


}
