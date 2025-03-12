package com.optxt.notesapp.userservice.service;

import com.optxt.notesapp.userservice.model.User;
import com.optxt.notesapp.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
