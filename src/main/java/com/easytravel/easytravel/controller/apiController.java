// package com.easytravel.easytravel.controller;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.easytravel.easytravel.model.Agence;
// import com.easytravel.easytravel.model.Reservation;
// import com.easytravel.easytravel.model.Travel;
// import com.easytravel.easytravel.model.User;
// import com.easytravel.easytravel.repository.ReservationRepository;
// import com.easytravel.easytravel.repository.TravelRepository;
// import com.easytravel.easytravel.service.AgenceService;
// import com.easytravel.easytravel.service.UserService;

// // import jakarta.validation.OverridesAttribute.List;


// @RestController
// public class apiController {
//     @Autowired
//     UserService userService;
//     @Autowired
//     AgenceService agenceService;
//     @Autowired
//     TravelRepository travelRepo;
//     @Autowired
//     ReservationRepository reservationRepo;
//     @GetMapping("/allUser")
//     public Iterable<User> allUser(){

//         System.out.println(userService.finAll());
//         // return "tester";
//         return (Iterable<User>) userService.finAll();
//         // return null;
//     }

//     @GetMapping("/allAgence")
//     public Iterable<Agence> allAgence(){
//         try {
//             System.out.println(agenceService.findAll());
//         } catch (Exception e) {
//             System.out.println(e.getMessage());

//         }
//         return  agenceService.findAll();
//     }
//     @GetMapping("/allTravels")
//     public Iterable<Travel> allTravel(){
//         try {
//             System.out.println(travelRepo.findAll());
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
            
//         }
//         return  travelRepo.findAll();
//     }

//     @GetMapping("/allReservation")
//     public Iterable<Reservation> allReservation(){
//         try {
//             System.out.println(reservationRepo.findAll());
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
            
//         }
//         return  reservationRepo.findAll();
//     }
// }
