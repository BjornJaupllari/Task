package com.example.LHIND.service.impl;

import com.example.LHIND.entity.User;
import com.example.LHIND.helper.Role;
import com.example.LHIND.repository.UserRepository;
import com.example.LHIND.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    private EnumSet<Role> validRoles = EnumSet.allOf(Role.class);

    // TODO check this part
    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        if (!validRoles.contains(user.getRole())) {
            throw new IllegalArgumentException("Invalid role provided.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            if (!validRoles.contains(userDetails.getRole())) {
                throw new IllegalArgumentException("Invalid role provided.");
            }
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        } else {
            // TODO error handler
            return null;
        }
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
