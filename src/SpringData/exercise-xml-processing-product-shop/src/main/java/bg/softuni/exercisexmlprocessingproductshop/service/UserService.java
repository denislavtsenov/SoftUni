package bg.softuni.exercisexmlprocessingproductshop.service;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.UserViewRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.User;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {
    void seedUsers() throws JAXBException, FileNotFoundException;

    User getRandomUser();

    UserViewRootDto findAllUsersWithAtLeastOneSoldProduct();
}
