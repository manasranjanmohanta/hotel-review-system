package com.ldtech.user.services.impl;

import com.ldtech.user.entites.User;
import com.ldtech.user.exceptions.ResourceNotFoundException;
import com.ldtech.user.repositories.UserRepository;
import com.ldtech.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
    }

    @Override
    public void updateUserById(User user, long userId) {
        User user1 = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user1.setUserName(user.getUserName());
        user1.setUserEmail(user.getUserEmail());
        user1.setUserAbout(user.getUserAbout());

        userRepository.save(user1);

    }

    @Override
    public void deleteByUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);

    }
}
