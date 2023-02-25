package com.yomabank.profileservice.service;

import com.yomabank.profileservice.repository.UserRepo;
import com.yomabank.profileservice.repository.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private UserRepo userRepo;
    @Autowired
    public MyService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @PostConstruct
    public void get(){
        List< User> users = this.userRepo.findAll();
        users.stream().forEach(u->{
            System.out.println(u.getId());
        });

    }
}
