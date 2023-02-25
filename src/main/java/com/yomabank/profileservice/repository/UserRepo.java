package com.yomabank.profileservice.repository;

import com.yomabank.profileservice.repository.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {
    public Page<UserEntity> findAll(Specification<UserEntity> spec, Pageable pageable);

}
