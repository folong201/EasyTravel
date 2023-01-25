package com.easytravel.easytravel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.easytravel.easytravel.model.Role;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.service.UserService;

import jakarta.validation.OverridesAttribute.List;

@RestController
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String homePage(){
        return "user/dashboard";
    }
    // @RequestMapping(value = {"/tester"}, method = RequestMethod.GET)
    @GetMapping("/tester")
    public String homePage2(){
        return "tester";
    }

}
