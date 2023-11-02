package com.learningorm.ORMLearning.services;

import com.learningorm.ORMLearning.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(int userId);
    User updateUser(User user,int userId);
    void deleteUser(int id);
    List<User> getAllUsers();

}
