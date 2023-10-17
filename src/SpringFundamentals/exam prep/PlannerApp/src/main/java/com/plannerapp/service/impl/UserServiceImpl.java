package com.plannerapp.service.impl;

import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .orElse(null);
    }
}
