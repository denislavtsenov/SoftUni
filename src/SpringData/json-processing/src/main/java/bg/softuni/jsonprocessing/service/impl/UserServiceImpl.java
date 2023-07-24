package bg.softuni.jsonprocessing.service.impl;

import bg.softuni.jsonprocessing.model.dto.UserSeedDto;
import bg.softuni.jsonprocessing.model.dto.UserSoldDto;
import bg.softuni.jsonprocessing.model.entity.User;
import bg.softuni.jsonprocessing.repository.UserRepository;
import bg.softuni.jsonprocessing.service.UserService;
import bg.softuni.jsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_PATH_FILE = "files/users.json";

    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {

        if (userRepository.count() > 0) {
            return;
        }

        File resource = new ClassPathResource(USERS_PATH_FILE).getFile();

        String fileContent = Files
                .readString(Path.of(resource.toURI()));

        UserSeedDto[] userSeedDtos = gson.fromJson(fileContent, UserSeedDto[].class);

        for (UserSeedDto userSeedDto : userSeedDtos) {

            if (validationUtil.isValid(userSeedDto)) {
                User user = modelMapper.map(userSeedDto, User.class);
                userRepository.save(user);
            }
        }
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);

    }

    @Override
    public List<UserSoldDto> findAllUsersWithAtLeastOneSoldProduct() {
        return userRepository
                .findAllBySoldProductsWithBuyerOrderByLastNameThenFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }
}

