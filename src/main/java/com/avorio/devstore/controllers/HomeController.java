package com.avorio.devstore.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.avorio.devstore.model.User;

import com.avorio.devstore.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class HomeController {
    @Autowired
    private UserService userService;
    User user;

    @GetMapping("/")
    public String home() {
        return "Welcome to the jungle!";
    }

    @PostMapping(path = "/login" ,consumes=MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody User user){
        System.out.println(user.toString() + "avrt");
        return userService.verifyUser(user);
    }
    
    @PostMapping(path = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUserInDataBase(@RequestBody User user) {
        userService.persist(user);
        return "saved";
    }

    @GetMapping("/getall")
    public String getMethodName() {
        return "Test";
    }
    
}
