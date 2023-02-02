package com.easytravel.easytravel.service;

import com.easytravel.easytravel.model.Agence;
// import com.easytravel.easytravel.model.Role;
import com.easytravel.easytravel.model.User;
import com.easytravel.easytravel.repository.AgenceRepository;
import com.easytravel.easytravel.repository.ReservationRepository;
import com.easytravel.easytravel.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationRepository reseratioRepo;
    @Autowired
    AgenceRepository agenceRepo;

    @Override
    public void saveUser(User user) {
        System.out.println("this is the user name ondside save user function implentation");
        System.out.println(user.getEmail());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        //here is the place to set the user role
    //    user.setRole(Role.ADMIN);
        userRepository.save(user);
    }

    @Override
    public List<Object> isUserPresent(User user) {
        boolean userExists = false;
        String message = null;
        Optional<User> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if(existingUserEmail.isPresent()){
            userExists = true;
            message = "Email Already Present!";
        }
        Optional<User> existingUserMobile = userRepository.findByMobile(user.getMobile());
        if(existingUserMobile.isPresent()){
            userExists = true;
            message = "Mobile Number Already Present!";
        }
        if (existingUserEmail.isPresent() && existingUserMobile.isPresent()) {
            message = "Email and Mobile Number Both Already Present!";
        }
        System.out.println("existingUserEmail.isPresent() - "+existingUserEmail.isPresent()+"existingUserMobile.isPresent() - "+existingUserMobile.isPresent());
        return Arrays.asList(userExists, message);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
                ));
    }

    @Override
    public Iterable<User> finAll() {
       var x=  userRepository.findAll();
        return x;
    }

    public void deleteReservation(Long id){
        reseratioRepo.deleteById(id);
    }

    public void changePassword(String password,Long id){
        //update user password
        User user2 = userRepository.findById(id).orElse(null);
        user2.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user2);

    }

    public void updateinfo(User user) {
        User user2 = userRepository.findById((long) user.getId()).orElse(null);
        if (user2!=null) {
            user2.setEmail(user.getEmail());
            user2.setFirstName(user.getFirstName());
            user2.setLastName(user.getLastName());
            userRepository.save(user2);
        }
    }

    public Object findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void UpdateAgnce(User user) {
        User user2 = userRepository.findById((long) user.getId()).orElse(null);
        if (user2!=null) {
            Agence agence = agenceRepo.findByDirectorId((long) user2.getId()).orElse(null);
            user2.setEmail(user.getEmail());
            user2.setFirstName(user.getFirstName());
            user2.setLastName(user.getLastName());
            if (agence!=null) {
                agence.setName(user2.getFirstName());
                agenceRepo.save(agence);
                userRepository.save(user2);
            }
        }
    }

}
