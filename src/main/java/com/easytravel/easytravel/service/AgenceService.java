package com.easytravel.easytravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.repository.AgenceRepository;
import com.easytravel.easytravel.repository.TravelRepository;
import com.easytravel.easytravel.repository.UserRepository;


@Service
public class AgenceService {
    @Autowired
    AgenceRepository agenceRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    TravelRepository travelRepo;

    public Iterable<Agence> findAll(){
        return agenceRepo.findAll();
    }
    public void delete(Long id){
        Agence agence = agenceRepo.findById(id).orElse(null);
        try {
            userRepo.deleteById(agence.getDirectorId());
            agenceRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTravel(Long DirectorId,Travel travel){
        Agence agence = agenceRepo.findByDirectorId(DirectorId).orElse(null);
        try {
            if (agence!=null) {
                travel.setAgence(agence);
                travel.setAgenceid(agence.getId());
                travel.setBus("VIP");
                System.out.println("before save");
                System.out.println(travel);
                travelRepo.save(travel);
                System.out.println("after save");
                System.out.println(travel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
