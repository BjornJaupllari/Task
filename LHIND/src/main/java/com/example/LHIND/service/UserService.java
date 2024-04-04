package com.example.LHIND.service;

import com.example.LHIND.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User createUser(User user);

    User updateUser(int id, User userDetails);

    void deleteUser(int id);
}