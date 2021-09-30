package com.example.cursofullstack.controllers;


import com.example.cursofullstack.dao.UserDAO;
import com.example.cursofullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "api/users")
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable Long id){
        userDao.remove(id);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){

        userDao.register(user);
    }
}
