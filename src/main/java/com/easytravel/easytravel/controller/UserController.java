package com.easytravel.easytravel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easytravel.easytravel.model.Reservation;
import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.repository.ReservationRepository;
import com.easytravel.easytravel.repository.TravelRepository;
import com.easytravel.easytravel.service.UserService;

import org.springframework.ui.Model;
// import jakarta.validation.OverridesAttribute.List;

// @RestController
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TravelRepository travelRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String homePage(){
        return "user/dashboard";
    }
    // @RequestMapping(value = {"/tester"}, method = RequestMethod.GET)
    @GetMapping("/tester")
    public String homePage2(){
        return "tester";
    }

    @GetMapping("/user/reservation")
    public String getAllReservation(Model model){
        model.addAttribute("travel", new Travel());
        System.out.println("List of travels");

        model.addAttribute("travels",travelRepo.findAll());
        // System.out.println(travelRepo.findAll());
        return "user/reservation";
    }


    @PostMapping("/user/findReservation")
    public String userReservationResult(@ModelAttribute Travel travel, Model model){
        System.out.println("fiding  of travels");
        System.out.println(travel);
        
        List<Travel> travels =  travelRepo.specialUser(travel.getDepart(), travel.getDestination(), travel.getDate(), travel.getHeure());
        // model.addAttribute()
        // model2.addAttribute("travel", new Travel()); 
        model.addAttribute("travels",travels);
        // System.out.println();
        return "/user/resultfind";
    }

    @GetMapping(value = "/user/saveRservation")
    public String saveReservation(@RequestParam Long id){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Travel travel = travelRepo.findById(id).orElse(null);
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEtat("demand");
        reservation.setNbPlace(1);
        reservation.setTravel(travel);
        System.out.println(reservation);
        // reservationRepo.save(reservation);
        return "user/dashboard";
    }

}
