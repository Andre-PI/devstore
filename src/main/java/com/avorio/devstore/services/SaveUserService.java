package com.avorio.devstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avorio.devstore.model.User;
import com.avorio.devstore.model.UserRepository;

@Service
public class SaveUserService {
    @Autowired
    CredentialsChecker credentialsChecker;
    @Autowired
    private UserRepository repo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public boolean persistUser(User user){
        String[] userData = {user.getEmail(),user.getUserName(),user.getPassword()};
        boolean checker;

        for (String string : userData) {
            checker = credentialsChecker.checkCredential(string);
            if(!checker){
                return false;
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return true;
    }
}
