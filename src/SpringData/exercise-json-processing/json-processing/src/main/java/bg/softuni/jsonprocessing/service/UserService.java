package bg.softuni.jsonprocessing.service;

import bg.softuni.jsonprocessing.model.dto.UserSoldDto;
import bg.softuni.jsonprocessing.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService  {
    void seedUsers() throws IOException;

    User getRandomUser();


    List<UserSoldDto> findAllUsersWithAtLeastOneSoldProduct();
}
