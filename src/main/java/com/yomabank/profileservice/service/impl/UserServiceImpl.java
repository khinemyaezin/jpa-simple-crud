package com.yomabank.profileservice.service.impl;

import com.yomabank.profileservice.constant.QueryOperator;
import com.yomabank.profileservice.datatransferobject.*;
import com.yomabank.profileservice.exception.ResourceNotFoundException;
import com.yomabank.profileservice.repository.UserRepo;
import com.yomabank.profileservice.repository.model.*;
import com.yomabank.profileservice.util.RepoHelper;
import com.yomabank.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setNrc(user.getNrc());
        user.getContactInfoList().stream().forEach(contactInfo -> {
            ContactInfoEntity contactEntity = new ContactInfoEntity();
            contactEntity.setContactValue(contactInfo.getContactValue());

            ContactTypeEntity contactTypeEntity = new ContactTypeEntity();
            contactTypeEntity.setId(contactInfo.getContactType().getId());

            contactEntity.setContactType(contactTypeEntity);
            contactEntity.setUser(entity);
            entity.setContactInfo(contactEntity);
        });
        user.getAddressList().stream().forEach(address -> {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddress(address.getAddress());
            addressEntity.setTownshipOrCity(address.getTownshipOrCity());
            addressEntity.setDistrict(address.getDistrict());
            addressEntity.setState(address.getState());
            addressEntity.setPostalCode(address.getPostalCode());
            addressEntity.setUser(entity);
            entity.setAddress(addressEntity);
        });

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
    public List<User> findALlUser(UserSearchCriteriaRequest user) {

        List<UserEntity> result;

        List<CriteriaFilter> filters = user.getCriteriaList().stream().map(criteria -> {
            return CriteriaFilter.builder()
                    .field(criteria.getField())
                    .operator(QueryOperator.resolve(criteria.getOperator()))
                    .value(criteria.getValue())
                    .build();
        }).collect(Collectors.toList());
        if (filters.size() > 0) {
            result = userRepo.findAll(RepoHelper.getSpecificationFromFilters(filters));
        } else {
            result = userRepo.findAll();
        }
        List<User> response = result.stream().map(userEntity -> {
            return new User(
                    userEntity.getId(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    userEntity.getNrc(),
                    new ArrayList<>(),
                    new ArrayList<>());
        }).collect(Collectors.toList());
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
                        userEntity.get().getContactInfoList().stream().map( contact -> {
                            return new ContactInfo(
                                    contact.getId(),
                                    contact.getContactValue(),
                                    new ContactType(
                                            contact.getContactType().getId()
                                    )
                            );
                        }).collect(Collectors.toList()),
                        userEntity.get().getAddressList().stream().map(addressEntity -> {
                            return new Address(
                                    addressEntity.getId(),
                                    addressEntity.getAddress(),
                                    addressEntity.getTownshipOrCity(),
                                    addressEntity.getDistrict(),
                                    addressEntity.getState(),
                                    addressEntity.getPostalCode()
                            );
                        }).collect(Collectors.toList())
                ) : null;
    }

    @Override
    public void deleteUserById(String id) {
        this.userRepo.deleteById(Long.parseLong(id));
    }

    @Override
    public void updateUser(User user,long id) {
        var userEntity = this.userRepo.findById(id);
        if(!userEntity.isPresent()) {
            throw new ResourceNotFoundException();
        }
        var entity = userEntity.get();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setNrc(user.getNrc());
        user.getContactInfoList().stream().forEach(contactInfo -> {
            ContactInfoEntity contactEntity = new ContactInfoEntity();
            contactEntity.setContactValue(contactInfo.getContactValue());

            ContactTypeEntity contactTypeEntity = new ContactTypeEntity();
            contactTypeEntity.setId(contactInfo.getContactType().getId());

            contactEntity.setContactType(contactTypeEntity);
            contactEntity.setUser(entity);
            entity.setContactInfo(contactEntity);
        });
        user.getAddressList().stream().forEach(address -> {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddress(address.getAddress());
            addressEntity.setTownshipOrCity(address.getTownshipOrCity());
            addressEntity.setDistrict(address.getDistrict());
            addressEntity.setState(address.getState());
            addressEntity.setPostalCode(address.getPostalCode());
            addressEntity.setUser(entity);
            entity.setAddress(addressEntity);
        });

        this.userRepo.save(entity);

    }


}
