package com.yomabank.profileservice.service;

import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.repository.model.UserEntity;

import java.util.List;


public interface UserService {

    public UserEntity createUser(UserEntity user);
    public List<UserEntity> findALlUser(UserEntity user);

    List<User> findALlUser(User user) throws IllegalAccessException;

    public UserEntity findUserById();
}
