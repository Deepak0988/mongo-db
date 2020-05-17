package com.learning.mongotest.service;

import com.learning.mongotest.model.AppUser;

import java.util.Optional;

public interface AppUserService {
    public AppUser saveUser(AppUser appUser);
    public Optional<AppUser> getUserById(Long id);
}
