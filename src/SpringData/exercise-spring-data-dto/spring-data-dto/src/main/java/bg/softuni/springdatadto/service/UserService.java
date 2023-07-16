package bg.softuni.springdatadto.service;

import bg.softuni.springdatadto.model.dto.UserLoginDto;
import bg.softuni.springdatadto.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
