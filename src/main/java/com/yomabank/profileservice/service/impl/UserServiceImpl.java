package com.yomabank.profileservice.service.impl;

import com.yomabank.profileservice.repository.UserRepo;
import com.yomabank.profileservice.repository.model.UserEntity;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;


    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<UserEntity> findALlUser(UserEntity user) {
        Specification specification = Specification.where(
                (u, cq, cb) -> cb.like(u.get("firstName"), "%" + user.getFirstName() + "%")
        ).and(Specification.where(
                (u, cq, cb) -> cb.like(u.get("lastName"), "%" + user.getLastName() + "%")
        ));
        return this.userRepo.findAll(specification);
    }

    @Override
    public UserEntity findUserById() {
        return null;
    }
}
