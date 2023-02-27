package com.yomabank.profileservice.service;

import com.yomabank.profileservice.datatransferobject.User;
import com.yomabank.profileservice.datatransferobject.UserSearchCriteriaRequest;

import java.util.List;


public interface UserService {

    public User createUser(User user);
    public List<User> findALlUser(UserSearchCriteriaRequest user);
    List<User> findALlUser(User user) throws IllegalAccessException;

    public User findUserById(String id);

    public void deleteUserById(String id) ;
    public void updateUser(User user,long id);
}
