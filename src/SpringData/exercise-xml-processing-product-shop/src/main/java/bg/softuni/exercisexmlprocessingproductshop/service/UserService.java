package bg.softuni.exercisexmlprocessingproductshop.service;

import bg.softuni.exercisexmlprocessingproductshop.model.entity.User;
import jakarta.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {
    void seedUsers() throws JAXBException, FileNotFoundException;

    User getRandomUser();
}
