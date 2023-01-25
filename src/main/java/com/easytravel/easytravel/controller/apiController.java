package com.easytravel.easytravel.controller;


import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.service.AgenceService;
import com.easytravel.easytravel.service.UserService;

// import jakarta.validation.OverridesAttribute.List;


@RestController
public class apiController {
    @Autowired
    UserService userService;
    @Autowired
    AgenceService agenceService;
    @GetMapping("/allUser")
    public Iterable<User> allUser(){
        // var user = userService.

        // User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
		// System.out.println(user.getRole());


        // ModelAndView nav = new ModelAndView("tester");
        // nav.addObject("users", userService.finAll());
        System.out.println(userService.finAll());
        // return "tester";
        return (Iterable<User>) userService.finAll();
        // return null;
    }

    @GetMapping("/allAgence")
    public Iterable<Agence> allAgence(){;
        return  agenceService.getAllAgence();
    }
}
