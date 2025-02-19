package com.example.megacitycabbackend.service;

import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.model.UserModel;
import com.example.megacitycabbackend.model.UserPrinciples;
import com.example.megacitycabbackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsername(username);

        if(user == null){
            System.out.println("User not found!");
            throw  new UsernameNotFoundException("User not found");
        }

        return new UserPrinciples(user);
    }


}
