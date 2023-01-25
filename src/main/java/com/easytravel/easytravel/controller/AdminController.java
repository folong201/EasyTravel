package com.easytravel.easytravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.service.AdminService;
import com.easytravel.easytravel.service.UserService;
import java.util.List;

import jakarta.validation.Valid;

// import ch.qos.logback.core.model.Model;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "admin/dashboard";
    }
    @RequestMapping(value = {"/admin/createAgence"}, method = RequestMethod.GET)
    public String admincreateAgence(Model model){
        model.addAttribute("user",new User());
        return "admin/createAgence";
    }
    @RequestMapping(value = {"/admin/saveAgence"}, method = RequestMethod.POST)
    public String registerUser(Model model, @Valid User user, BindingResult bindingResult){
        System.out.println(user.getMobile());
        if(bindingResult.hasErrors()){
            model.addAttribute("successMessage", "User registered successfully! avec erreur simple");
            model.addAttribute("bindingResult", bindingResult);
            System.out.println(bindingResult);
            return "auth/register";
        }
        List <Object> userPresentObj = userService.isUserPresent(user);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1)+"erreur de presence");
            return "admin/createAgence";
        }

        userService.saveUser(user);
        model.addAttribute("successMessage", "User registered successfully! auth login should be returned");
        adminService.createAgence(user.getMobile());
        return "admin/dashboard";
    }

    @RequestMapping(value = {"/admin/agences"}, method = RequestMethod.GET)
    public String getAgence(){
        // model.addAttribute("user",new User());
        return "admin/agence";
    }
}


