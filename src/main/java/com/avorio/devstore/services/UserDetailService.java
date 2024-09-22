package com.avorio.devstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avorio.devstore.model.UserRepository;
@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository repo; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserPrincipal(repo.findByUserName(username));
    }
    
}
