package com.yomabank.profileservice.service.impl;

import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.repository.UserRepo;
import com.yomabank.profileservice.repository.model.UserEntity;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public List<User> findALlUser(User user) throws IllegalAccessException {
        Specification specification;
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            Optional value = Optional.ofNullable(field.get(user));
            if(value.isPresent()) {
                specification = Specification.where(
                        (u, cq, cb) -> cb.like(u.get(field.getName()), "%" + value + "%")
                );
            }
        }

        Specification.where(
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
