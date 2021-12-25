package com.cihanozmen.springboot.mongodb.service.entityService;

import com.cihanozmen.springboot.mongodb.entity.User;
import com.cihanozmen.springboot.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityService userEntityService;

    @Override
    public List<User> findAll() {
        return userEntityService.findAll();
    }

    @Override
    public User findById(String id) {
        return userEntityService.findById(id);
    }

    @Override
    public User save(User user) {
        return userEntityService.save(user);
    }

    @Override
    public void deleteById(String id) {
        userEntityService.deleteById(id);
    }
}
