package com.abhicoder.universityapi.service;

import com.abhicoder.universityapi.model.User;
import com.abhicoder.universityapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User newuser) {
        return userRepository.save(newuser);
    }
}
