package com.avorio.devstore.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.avorio.devstore.model.User;
import com.avorio.devstore.services.SaveUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HomeController {
    @Autowired
    SaveUserService saveUserService;
    User user;

    @GetMapping("/")
    public String home() {
        return "Welcome to the jungle!";
    }
    
    @PostMapping(path = "/saveuser" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUserInDataBase(@RequestBody User user) {
        saveUserService.persistUser(user);
        return "saved";
    }

    @GetMapping("/getall")
    public String getMethodName(@RequestParam String param) {
        return "Test";
    }
    

    
}
