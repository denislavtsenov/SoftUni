package com.plannerapp.service;

import com.plannerapp.model.entity.UserEntity;

public interface UserService {
    UserEntity findByUsernameAndPassword(String username, String password);
}
