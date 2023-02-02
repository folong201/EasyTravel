package com.easytravel.easytravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

import com.easytravel.easytravel.model.Reservation;
import com.easytravel.easytravel.model.User;

// @Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query(value = "SELECT * FROM reservations R",nativeQuery = true)
    //r WHERE r.user=?1 ",nativeQuery = true)
    public List<Reservation> findByUser(User user);
}
