package com.easytravel.easytravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.easytravel.easytravel.model.Reservation;
import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.repository.ReservationRepository;
import com.easytravel.easytravel.repository.TravelRepository;
import com.easytravel.easytravel.service.AgenceService;
import com.easytravel.easytravel.service.UserServiceImpl;

import org.springframework.ui.Model;
// import jakarta.validation.OverridesAttribute.List;

// @RestController
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TravelRepository travelRepo;
    @Autowired
    ReservationRepository reservationRepo;
    @Autowired
    AgenceService agenceService;

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

    @GetMapping(value = "/user/saveReservation")
    public String saveReservation(@RequestParam Long id){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Travel travel = travelRepo.findById(id).orElse(null);
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEtat("demand");
        reservation.setNbPlace(1);
        reservation.setTravel(travel);
        System.out.println(reservation);
        if(travel!=null){
            reservation.setTravel(travel);
            reservationRepo.save(reservation);
            System.out.println("voyage trouver");
            System.out.println(travel);
        }
        return "user/dashboard";
    }

    @GetMapping(value = "/user/myReservation")
    public String myReservation(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List <Reservation> myReserv = reservationRepo.findByUser(user);
        List<Reservation> allReservation =myReserv;// new ArrayList<Reservation>();
        List<Reservation> reservations = new ArrayList<Reservation>();
        for (int i = 0; i < allReservation.size(); i++) {
            if (allReservation.get(i).getUser().getId()==user.getId()) {
                // System.out.println(allReservation);
                reservations.add(allReservation.get(i));
            }
        }
        model.addAttribute("reservations",reservations);

        return "user/myReservation";
    }

    @GetMapping(value = "user/reserve/delete")
    public String deleteReservation(@RequestParam Long id){
        userService.deleteReservation(id);
        return "redirect:/user/myReservation";
    }

    @GetMapping(value = "user/agences")
    public String agenceList(Model model){
        model.addAttribute("travels", agenceService.findAll());
        return "user/agences";
    }
    @GetMapping(value="user/agenceTravels")
    public String aganeceTravels(@RequestParam Long id,Model model){
        model.addAttribute("travels", agenceService.findByAgence(id));
        return "user/agenceTravels";
    }
    @GetMapping(value = "updatePassword")
    public String updatePasssword(){
        return "auth/updatePassword";
    }
    @PostMapping(value = "updatePassword")
    public RedirectView saveUpdatedPassword(@RequestParam("password") String password){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.changePassword(password,(long) user.getId());
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/logout");
        return redirectView;
        // return "redirect:/";
    }

    @GetMapping(value="updateAccount")
    public String updateAccount(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);
        return "auth/updateAccount";
    }

    @PostMapping(value = "updateAccount")
    public String updateAccountSave(@ModelAttribute User user){
        userService.updateinfo(user);
        return "redirect:logout";
    }
}
