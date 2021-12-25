package com.cihanozmen.springboot.mongodb.service;

import com.cihanozmen.springboot.mongodb.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User save(User user);

    void deleteById(String id);
}
