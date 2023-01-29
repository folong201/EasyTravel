package com.easytravel.easytravel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.repository.AgenceRepository;
import com.easytravel.easytravel.repository.UserRepository;

// import com.easytravel.easytravel.model.Agence;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    AgenceRepository agenceRepo;


    public void createAgence(String mobile){
        Optional<User> user = userRepo.findByMobile(mobile);
        if(user!=null) {
           Agence agence = new Agence((long) user.get().getId(),user.get().getFirstName());
        //    agence.setDirectorId(user);
           agenceRepo.save(agence);
        }
    }
}
