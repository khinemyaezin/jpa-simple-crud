package com.yomabank.profileservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yomabank.profileservice.dto.ResponseBody;
import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.dto.UserRequest;
import com.yomabank.profileservice.repository.model.UserEntity;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ResponseBody> getUsers(@RequestBody UserRequest userRequest) throws JsonProcessingException {
        List<User> userList = this.userService.findALlUser(userRequest);
        ResponseBody response = new ResponseBody<User>();
        response.setDetails(userList);
        return ResponseEntity.ok(response);
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
