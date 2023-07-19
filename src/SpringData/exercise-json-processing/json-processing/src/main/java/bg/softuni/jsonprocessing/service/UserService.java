package bg.softuni.jsonprocessing.service;

import bg.softuni.jsonprocessing.model.entity.User;

import java.io.IOException;

public interface UserService  {
    void seedUsers() throws IOException;

    User getRandomUser();
}
