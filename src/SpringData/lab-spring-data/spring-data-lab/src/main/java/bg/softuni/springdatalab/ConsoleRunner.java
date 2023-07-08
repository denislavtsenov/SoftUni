package bg.softuni.springdatalab;

import bg.softuni.springdatalab.services.AccountService;
import bg.softuni.springdatalab.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private AccountService accountService;
    private UserService userService;

    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
