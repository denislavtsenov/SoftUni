package bg.softuni.springdatalab.services;

import bg.softuni.springdatalab.models.User;
import bg.softuni.springdatalab.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {

    }
}
