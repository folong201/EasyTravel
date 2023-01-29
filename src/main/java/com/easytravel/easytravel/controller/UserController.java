package com.easytravel.easytravel.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.easytravel.easytravel.model.Role;
import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.model.User;
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
        
        // List<Travel> travels =  (List<Travel>) travelRepo.specialUser(travel.getDepart(), travel.getDestination(), travel.getDate(), travel.getHeure());
        // model.addAttribute()
        // model2.addAttribute("travel", new Travel()); 
        // model.addAttribute("travels",travelRepo.findAll());
        // System.out.println(travelRepo.specialUser(travel.getDepart(), travel.getDestination(), travel.getDate(), travel.getHeure()));
        return "redirect:/user/reservation";
    }

}
