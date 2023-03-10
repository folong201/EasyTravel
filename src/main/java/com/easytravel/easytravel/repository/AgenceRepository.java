package com.easytravel.easytravel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytravel.easytravel.model.Agence;

// import jakarta.validation.OverridesAttribute.List;
@Repository
public interface AgenceRepository  extends JpaRepository<Agence,Long>{

    Optional<Agence> findByDirectorId(Long directorId);
    // List<Travel> findTravels(Long id);
    // @Query("SELECT u FROM Agences u WHERE u.directorId= ?1")
    // Optional <Agence> findByDirectorId(Long id);
}
