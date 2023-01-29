package com.easytravel.easytravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytravel.easytravel.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    
}
