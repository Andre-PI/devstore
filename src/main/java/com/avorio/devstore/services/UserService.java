package com.avorio.devstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.avorio.devstore.model.User;


@Service
public class UserService {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private SaveUserService saveUserService;
    @Autowired
    private JWTService jwtService;
   

    public void persist(User user){
        saveUserService.persistUser(user);
    }

    public String verifyUser(User user){
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateToken(user.getUserName());
        }
        return "fail"; 
    }
    


}
