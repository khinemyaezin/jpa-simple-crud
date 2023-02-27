package com.yomabank.profileservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yomabank.profileservice.datatransferobject.global.ResponseBody;
import com.yomabank.profileservice.datatransferobject.User;
import com.yomabank.profileservice.datatransferobject.UserSearchCriteriaRequest;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseBody> getUsers(@RequestBody UserSearchCriteriaRequest userRequest){
        List<User> userList = this.userService.findALlUser(userRequest);
        ResponseBody response = new ResponseBody<User>();
        response.setDetails(userList);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "")
    public ResponseEntity<ResponseBody> saveUser(@RequestBody User user) throws JsonProcessingException {
        User createdUser = this.userService.createUser(user);
        ResponseBody response = new ResponseBody<User>();
        response.setDetails(createdUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseBody> findUserByID(@PathVariable("id") String id){
        User u = this.userService.findUserById(id);
        ResponseBody response = new ResponseBody<User>();
        response.setDetails(u);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseBody> updateUserByID(@PathVariable("id") String id,@RequestBody User user){
        this.userService.updateUser(user,Long.parseLong(id));
        ResponseBody response = new ResponseBody<User>();
        return ResponseEntity.ok(response);
    }

}
