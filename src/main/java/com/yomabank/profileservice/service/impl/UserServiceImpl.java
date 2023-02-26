package com.yomabank.profileservice.service.impl;

import com.google.common.collect.Lists;
import com.yomabank.profileservice.constant.QueryOperator;
import com.yomabank.profileservice.dto.Filter;
import com.yomabank.profileservice.dto.User;
import com.yomabank.profileservice.dto.UserRequest;
import com.yomabank.profileservice.repository.UserRepo;
import com.yomabank.profileservice.repository.helper.RepoHelper;
import com.yomabank.profileservice.repository.model.UserEntity;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public User createUser(User user) {
        UserEntity entity =  new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getNrc(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Optional<UserEntity> userEntity = Optional.ofNullable(this.userRepo.save(entity));
        return userEntity.isPresent() ?
           new User(
                    userEntity.get().getId(),
                    userEntity.get().getFirstName(),
                    userEntity.get().getLastName(),
                    userEntity.get().getNrc(),
                    new ArrayList<>(),
                    new ArrayList<>()
            ) : null;

    }

    @Override
    public List<User> findALlUser(UserRequest user) {

        List<UserEntity> result;

        List<Filter> filters = Lists.transform(user.getCriteriaList(), criteria->{
            return Filter.builder()
                    .field(criteria.getField())
                    .operator(QueryOperator.resolve(criteria.getOperator()))
                    .value(criteria.getValue())
                    .build();

        });
        if(filters.size()>0) {
            result =  userRepo.findAll(RepoHelper.getSpecificationFromFilters(new UserEntity(),filters));
        }else {
            result =  userRepo.findAll();
        }
        List<User> response = Lists.transform(result, userEntity->{
            return new User(
                    userEntity.getId(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    userEntity.getNrc(),
                    new ArrayList<>(),
                    new ArrayList<>()
            );
        });
        return response;
    }

    @Override
    public List<User> findALlUser(User user) throws IllegalAccessException {
        return null;
    }

//    public List<User> findALlUser(User u) {
//        Specification<User> spec;
//
//        if (u.getFirstName() != null && u.getFirstName().isEmpty()) {
//            spec = Specification.where( (root, query, criteriaBuilder) -> {
//                return criteriaBuilder.like(
//                        root.get( "firstName" ), "%"+ u.getFirstName() +"%");
//            });
//        }
//        if (u.getLastName() != null && u.getFirstName().isEmpty()) {
//            spec = Specification.where( (root, query, criteriaBuilder) -> {
//                return criteriaBuilder.like(
//                        root.get( "firstName" ), "%"+ u.getFirstName() +"%");
//            });
//        }
//
//
//    }


    @Override
    public User findUserById(String id) {
        Optional<UserEntity> userEntity = this.userRepo.findById(Long.parseLong(id));
        return userEntity.isPresent() ?
            new User(
                    userEntity.get().getId(),
                    userEntity.get().getFirstName(),
                    userEntity.get().getLastName(),
                    userEntity.get().getNrc(),
                    new ArrayList<>(),
                    new ArrayList<>()
            ) : null ;
    }

    @Override
    public void deleteById(String id) {
        this.userRepo.deleteById(Long.parseLong(id));
    }


}
