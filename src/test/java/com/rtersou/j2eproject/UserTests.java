package com.rtersou.j2eproject;

import com.rtersou.j2eproject.controllers.UserController;
import com.rtersou.j2eproject.models.user.User;
import com.rtersou.j2eproject.models.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    /*
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserController controller;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void canRetrieveByIdWhenExists() {
        // given

        given(userRepository.getOne(Long.valueOf(2)))
                .willReturn(new User());

        // when
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("/users/2", User.class);

        // then
        assertThat(userResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(userResponseEntity.getBody().equals(new User()));
    }

     */
}
