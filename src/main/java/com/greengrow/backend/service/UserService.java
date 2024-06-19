package com.greengrow.backend.service;

import com.greengrow.backend.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User updateUser(Long id, User userDetails);

    User getUserById(Long id);

    void deleteUserById(Long id);

    List<User> getAllUsers();
}
