package com.cihanozmen.springboot.mongodb.controller;

import com.cihanozmen.springboot.mongodb.entity.User;
import com.cihanozmen.springboot.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<User> save(@RequestParam User user){
        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.deleteById(id);
    }
}
