package com.learningorm.ORMLearning.services.impl;

import com.learningorm.ORMLearning.entities.User;
import com.learningorm.ORMLearning.repositories.UserRepository;
import com.learningorm.ORMLearning.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;//Spring automatically creates a new class implementing UserService and creates an object for it
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(()->new RuntimeException("Cannot find the user with given id"));
        return user;
    }

    @Override
    public User updateUser(User user, int userId) {
        user.setId(userId);
        User updatedUser = userRepository.save(user);
        logger.info(""+updatedUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
        logger.info("user deleted");
        logger.info(""+userRepository.findById(userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
