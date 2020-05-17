package com.learning.mongotest.controller;

import com.learning.mongotest.model.AppUser;
import com.learning.mongotest.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/save")
    public AppUser saveUser(){
        AppUser appUser = new AppUser();
        appUser.setFirstName("Deepak");
        appUser.setLastName("Chauhan");
        appUser.setId((long) 1);
        return appUserService.saveUser(appUser);
    }

    @GetMapping("/user/{id}")
    public Optional<AppUser> getUser(@PathVariable Long id){
        return appUserService.getUserById(id);
    }
}
