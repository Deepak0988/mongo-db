package com.learning.mongotest.integration;

import com.learning.mongotest.controller.AppController;
import com.learning.mongotest.model.AppUser;
import com.learning.mongotest.service.AppUserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AppController.class)
@RunWith(SpringRunner.class)
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AppUserService appUserService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnUser() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setLastName("Chauhan");
        appUser.setFirstName("Deepak");
        appUser.setId(1L);
        Mockito.when(appUserService.getUserById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(appUser));
        MvcResult result = this.mockMvc.perform(get("/user/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andReturn();
    }

}
