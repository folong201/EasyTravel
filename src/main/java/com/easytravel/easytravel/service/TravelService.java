package com.easytravel.easytravel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytravel.easytravel.model.Travel;
import com.easytravel.easytravel.repository.TravelRepository;

@Service
public class TravelService {
    @Autowired
    TravelRepository travelRepo;
    public Travel findById(Long id){
        return travelRepo.findById((Long) id).orElse(null);
    }
    public void updateTravel(Travel travel) {
        Travel travel2 = travelRepo.findById(travel.getId()).orElse(null);
        if (travel2!=null) {
            travel2.setDepart(travel.getDepart());
            travel2.setDestination(travel.getDestination());
            travel2.setDate(travel.getDate());
            travel2.setHeure(travel.getHeure());
            travel2.setTarif(travel.getTarif());
            travelRepo.save(travel2);
        }
    }
}
