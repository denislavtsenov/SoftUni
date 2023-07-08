package bg.softuni.springdatalab.services;

import bg.softuni.springdatalab.models.Account;
import bg.softuni.springdatalab.models.User;
import bg.softuni.springdatalab.repositories.AccountRepository;
import bg.softuni.springdatalab.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(User user) {

        User newUser = userRepository.getByUsername(user.getUsername());

        if (newUser == null) {
            userRepository.saveAndFlush(user);
        }
    }
}
