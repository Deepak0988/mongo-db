package com.learning.mongotest.controller;

import com.learning.mongotest.model.AppUser;
import com.learning.mongotest.service.AppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Api(value = "Mongo Test Application", description = "Test Application For Mongo")
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
    @ApiOperation(value = "View a list of available employees", response = AppUser.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Optional<AppUser> getUser(@PathVariable Long id){
        return appUserService.getUserById(id);
    }
}
