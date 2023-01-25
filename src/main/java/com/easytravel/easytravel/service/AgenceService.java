package com.easytravel.easytravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytravel.easytravel.model.Agence;
import com.easytravel.easytravel.repository.AgenceRepository;

@Service
public class AgenceService {
    @Autowired
    AgenceRepository agenceRepo;

    public Iterable<Agence> getAllAgence(){
        return agenceRepo.findAll();
    }
}
