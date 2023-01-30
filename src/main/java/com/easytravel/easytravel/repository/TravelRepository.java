package com.easytravel.easytravel.repository;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Long> {
    // List<Travel> findByAgenceId(Long id);
    // List<Travel> findByAgence(Agence agence);
    @Query(value = "SELECT * FROM Travels t WHERE t.depart=?1 AND t.destination=?2",nativeQuery = true)
    public List<Travel> specialUser(String depart,String destination,String date,String heure);
}
