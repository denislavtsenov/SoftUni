package com.plannerapp.service.impl;

import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.service.UserServiceModel;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);

        userRepository.save(user);
    }

}
