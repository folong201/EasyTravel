package com.easytravel.easytravel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.easytravel.easytravel.model.Travel;
import org.springframework.web.bind.annotation.RequestParam;

// import ch.qos.logback.core.model.Model;

@Controller
public class DirectorController {
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
    public String createTravelsave(@ModelAttribute Travel travel,Model model){
            Travel x= travel;
            System.out.println(x);
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-mm-dd"); 
            Date date;
            // try {
            //     date = DateFor.parse(travel.getDate().toString());
            //     System.out.println(date);
            // } catch (ParseException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
        return "director/createTravel";
    }

    @GetMapping(value = "/director/travelList")
    public String getMethodName() {
        return "director/travelList";
    }

}
