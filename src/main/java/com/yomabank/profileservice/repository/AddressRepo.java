package com.yomabank.profileservice.repository;

import com.yomabank.profileservice.repository.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity,Long> {
}
