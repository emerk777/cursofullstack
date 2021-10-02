package com.example.cursofullstack.controllers;

import com.example.cursofullstack.dao.UserDAO;
import com.example.cursofullstack.dao.UserDAOImpl;
import com.example.cursofullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){

        return userDao.verifyUserCredentials(user) ? "OK" : "Fail";

    }


}
