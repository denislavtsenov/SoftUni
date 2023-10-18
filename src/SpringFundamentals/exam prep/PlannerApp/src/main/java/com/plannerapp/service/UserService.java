package com.plannerapp.service;

import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logoutUser();
}
