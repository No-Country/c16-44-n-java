package com.marketplace.administratorservice.repository;

import com.marketplace.administratorservice.entity.AdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<AdminEntity, String> {
}
