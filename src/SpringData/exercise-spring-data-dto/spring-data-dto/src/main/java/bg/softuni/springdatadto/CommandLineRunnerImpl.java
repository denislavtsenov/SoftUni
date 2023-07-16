package bg.softuni.springdatadto;

import bg.softuni.springdatadto.model.dto.GameAddDto;
import bg.softuni.springdatadto.model.dto.UserLoginDto;
import bg.softuni.springdatadto.model.dto.UserRegisterDto;
import bg.softuni.springdatadto.service.GameService;
import bg.softuni.springdatadto.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {

            System.out.println("Enter your command:");
            String[] commands = bufferedReader.readLine().split("\\|");
            String command = commands[0];
            String email;
            String password;

            switch (command) {
                case "RegisterUser":
                    email = commands[1];
                    password = commands[2];
                    String confirmPassword = commands[3];
                    String fullName = commands[4];

                    userService.registerUser(new UserRegisterDto(
                            email, password, confirmPassword, fullName
                    ));
                    break;
                case "LoginUser":
                    email = commands[1];
                    password = commands[2];
                    userService.loginUser(new UserLoginDto(
                            email, password
                    ));
                    break;
                case "Logout":
                    userService.logout();
                    break;
                case "AddGame":
                    String title = commands[1];
                    BigDecimal price = new BigDecimal(commands[2]);
                    Double size = Double.parseDouble(commands[3]);
                    String trailer = commands[4];
                    String thumbnailUrl = commands[5];
                    String description = commands[6];
                    LocalDate releaseDate = LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    gameService.addGame(new GameAddDto(title, price, size, trailer, thumbnailUrl,
                            description, releaseDate));

                case "EditGame":
                    Long id = Long.parseLong(commands[1]);
                    BigDecimal newPrice = new BigDecimal(commands[2].split("=")[1]);
                    Double newSize = Double.parseDouble(commands[3].split("=")[1]);

                    gameService.editGame(id, newPrice, newSize);
            }
        }
    }
}
