package com.yomabank.profileservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.repository.model.UserEntity;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private ObjectMapper objectMapper;
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<User> getUsers() throws JsonProcessingException {
        User criteria = new User();
        criteria.setFirstName("hein htet");


        return ResponseEntity.ok(criteria);
    }
//    @PostConstruct
//    public void getUsers() {
//        UserEntity criteria = new UserEntity();
//        criteria.setFirstName("kmz");
//        criteria.setLastName("zin");
//        List<UserEntity> users = this.userService.findALlUser(criteria);
//        users.stream().forEach( u-> {
//            System.out.println(u.getFirstName());
//        });
//    }
}
