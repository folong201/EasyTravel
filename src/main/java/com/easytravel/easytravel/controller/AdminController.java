package com.easytravel.easytravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.service.AdminService;
import com.easytravel.easytravel.service.AgenceService;
import com.easytravel.easytravel.service.UserServiceImpl;

import java.util.List;

import jakarta.validation.Valid;

// import ch.qos.logback.core.model.Model;

@Controller
public class AdminController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AdminService adminService;
    @Autowired
    AgenceService agenceService;
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
        System.out.println(user);
        // return "admin/createAgence";
        if(bindingResult.hasErrors()){
            model.addAttribute("successMessage", "User registered successfully! avec erreur simple");
            model.addAttribute("bindingResult", bindingResult);
            System.out.println(bindingResult);
            return "admin/createAgence";
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
    public String getAgence(Model model){
        model.addAttribute("agences",agenceService.findAll());
         Iterable<Agence> agences =  agenceService.findAll();
         System.out.println(agences);
        return "admin/agence";
    }
    @GetMapping("/admin/agence/delete")
    public String deleteAgence(@RequestParam Long id,Model model){
        System.out.println(id);

        agenceService.delete(id);
        model.addAttribute("agences",agenceService.findAll());
         Iterable<Agence> agences =  agenceService.findAll();
         System.out.println(agences);
        return "admin/agence";
    }
    @GetMapping("/admin/agence/edit")
    public String UpdateAgnce(@RequestParam Long id,Model model){
        User  director = (User) userService.findById(id);
        if (director==null) {
            return "redirect:admin/dasboard";
        }
        model.addAttribute("user",director);
        return "admin/agenceUpdate";
    }
    @PostMapping("/admin/agence/edit")
    public String UpdateAgnceSave(@ModelAttribute User user,Model model){
        userService.UpdateAgnce(user);
        System.out.println(user);
        return "redirect:/admin/agences";
    }
}


