package com.cihanozmen.springboot.mongodb.repository;

import com.cihanozmen.springboot.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
