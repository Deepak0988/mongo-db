package com.learning.mongotest.service.impl;

import com.learning.mongotest.model.AppUser;
import com.learning.mongotest.repository.AppUserRepo;
import com.learning.mongotest.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public AppUser saveUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    public Optional<AppUser> getUserById(Long id) {
        return appUserRepo.findById(id);
    }
}
