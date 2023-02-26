package com.yomabank.profileservice.service;

import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.dto.UserSearchCriteriaRequest;

import java.util.List;


public interface UserService {

    public User createUser(User user);
    public List<User> findALlUser(UserSearchCriteriaRequest user);
    List<User> findALlUser(User user) throws IllegalAccessException;

    public User findUserById(String id);

    public void deleteById(String id) ;
}
