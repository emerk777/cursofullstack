package com.example.cursofullstack.controllers;


import com.example.cursofullstack.dao.UserDAO;
import com.example.cursofullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDao ;

    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setName("Juan");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers(){
        return userDao.getUsers();
    }
}
