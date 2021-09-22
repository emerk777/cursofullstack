package com.example.cursofullstack.dao;

import com.example.cursofullstack.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void remove(Long id);
}
