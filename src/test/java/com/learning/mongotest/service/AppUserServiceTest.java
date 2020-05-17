package com.learning.mongotest.service;

import com.learning.mongotest.model.AppUser;
import com.learning.mongotest.repository.AppUserRepo;
import com.learning.mongotest.service.impl.AppUserServiceImpl;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserServiceTest {
    @Mock
    AppUserRepo appUserRepo;
    AppUser user;

    @InjectMocks
    AppUserServiceImpl appUserService;

    @BeforeEach
    public void init(){
        user = new AppUser();
        user.setId((long) 1);
        user.setFirstName("Deepak");
        user.setLastName("Chauhan");
    }

    @Test
    public void shouldReturnAppUser(){
        System.out.println("Starting Test...");

    doReturn(Optional.of(user)).when(appUserRepo).findById(ArgumentMatchers.anyLong());
        Optional<AppUser> result = appUserService.getUserById(2L);
        verify(appUserRepo,times(1)).findById(ArgumentMatchers.anyLong());
        assertEquals(result,Optional.of(user));
        }
        }
