package com.dictionaryapp.service;

import com.dictionaryapp.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void registerUser(UserServiceModel userServiceModel);

    void logoutUser();
}
