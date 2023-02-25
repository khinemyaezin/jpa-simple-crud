package com.yomabank.profileservice.repository;

import com.yomabank.profileservice.repository.model.ContactTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTypeRepo extends JpaRepository<ContactTypeEntity,String> {
}
