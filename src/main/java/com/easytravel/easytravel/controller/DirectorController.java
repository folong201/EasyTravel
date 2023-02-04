package com.easytravel.easytravel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.repository.TravelRepository;
import com.easytravel.easytravel.service.AgenceService;
import com.easytravel.easytravel.service.TravelService;

import org.springframework.web.bind.annotation.RequestParam;

// import ch.qos.logback.core.model.Model;

@Controller
public class DirectorController {
    @Autowired
    AgenceService aService;
    @Autowired
    TravelRepository travelRepo;
    @Autowired 
    TravelService travelService;
    @GetMapping("/director/dashboard")
    public String index() {
        return "/director/dashboard";
    }

    @GetMapping("/director/createTravel")
    public String createTravel(Model model) {
        model.addAttribute("travel", new Travel());
        return "director/createTravel";
    }

    @PostMapping("/director/createTravel")
    public String createTravelsave(@ModelAttribute Travel travel, Model model) {
        try {
            Travel x = travel;
            System.out.println(travel);
            User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            aService.createTravel((long) user.getId(), travel);
            System.out.println(user.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(aService.findAll());
        return "redirect:/director/travelList";
    }
    @GetMapping(value = "/director/travelList")
    public String getTravelList(Model model) {

        System.out.println("List of travels");
        model.addAttribute("travels",travelRepo.findAll());
        System.out.println(travelRepo.findAll());
        return "director/travelList";
    }

    @GetMapping("/director/travel/delete")
    public String deleteTravel(@RequestParam Long id,Model model){

        //ici il faut ecrire le code pour suprimer le voyage
        travelRepo.deleteById(id);
        model.addAttribute("travels",travelRepo.findAll());
        System.out.println(travelRepo.findAll());
        return "director/travelList";
    }

    @GetMapping(value = "director/updateTravel")
    public String updateTravel(@RequestParam Long id,Model model){
        Travel travel =  travelService.findById(id);
        if (travel==null) {
            return "redirect:director/dashboard";
        }
        model.addAttribute("travel",travel);
        return "director/updateTravel";
    }

    @PostMapping(value = "director/updateTravel")
    public String uodateTravel(@ModelAttribute Travel travel){
        travelService.updateTravel(travel);
        System.out.println(travel);
        return "redirect:/director/travelList";
    }

}
