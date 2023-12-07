package com.ldtech.user.services;

import com.ldtech.user.entites.User;

import java.util.List;

public interface UserService {

    // create user
    User createUser(User user);

    // get all users
    List<User> getAllUsers();

    // get only one user
    User getUserById(long userId);

    // update user by id
    void updateUserById(User user, long userId);
    // delete user by id
    void deleteByUserId(long userId);
}
