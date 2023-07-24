package bg.softuni.exercisexmlprocessingproductshop.service.impl;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.importDto.UserSeedRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.User;
import bg.softuni.exercisexmlprocessingproductshop.repository.UserRepository;
import bg.softuni.exercisexmlprocessingproductshop.service.UserService;
import bg.softuni.exercisexmlprocessingproductshop.utils.ValidationUtil;
import bg.softuni.exercisexmlprocessingproductshop.utils.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_PATH = "src/main/resources/files/users.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final UserRepository userRepository;

    public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, UserRepository userRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() throws JAXBException, FileNotFoundException {
        if (userRepository.count() > 0) {
            return;
        }

        UserSeedRootDto userSeedRootDto = xmlParser.fromFile(USERS_FILE_PATH, UserSeedRootDto.class);

        userSeedRootDto.getUsers()
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count()) + 1;

        return userRepository.findById(randomId).orElse(null);
    }


}
