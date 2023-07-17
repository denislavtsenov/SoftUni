package bg.softuni.springdatadto.service.impl;

import bg.softuni.springdatadto.model.dto.GameAddDto;
import bg.softuni.springdatadto.model.dto.GameViewDetailDto;
import bg.softuni.springdatadto.model.dto.GameViewPriceTitleDto;
import bg.softuni.springdatadto.model.entity.Game;
import bg.softuni.springdatadto.repository.GameRepository;
import bg.softuni.springdatadto.service.GameService;
import bg.softuni.springdatadto.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
        game.setImageThumbnail(gameAddDto.getThumbnailURL());

        gameRepository.save(game);

        System.out.println("Added " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(Long id, BigDecimal newPrice, Double newSize) {

        Game game = gameRepository.findById(id)
                .orElse(null);

        if (game != null) {
            game.setPrice(newPrice);
            game.setSize(newSize);

            gameRepository.save(game);
            System.out.println("Edited " + game.getTitle());
        } else {
            System.out.println("Game with this ID does not exist");
        }
    }

    @Override
    public void deleteGame(Long id) {

        Game game = gameRepository.findById(id)
                .orElse(null);

        if (game != null) {
            System.out.println("Deleted " + game.getTitle());
            gameRepository.delete(game);
        } else {
            System.out.println("Game with this ID does not exist");
        }
    }

    @Override
    public void printPriceAndTitleAllGames(GameViewPriceTitleDto gameViewPriceTitleDto) {

        List<Game> games = gameRepository.findAll();

        if (games.isEmpty()) {
            System.out.println("You don't have any games");
            return;
        }

        games
                .forEach(game -> {
                    GameViewPriceTitleDto gameDto = modelMapper.map(game, GameViewPriceTitleDto.class);
                    System.out.printf("%s %.2f%n", gameDto.getTitle(), gameDto.getPrice());
                });
    }

    @Override
    public void printGameDetailsByTitle(GameViewDetailDto gameViewDetailDto) {

        Game game = gameRepository.findByTitle(gameViewDetailDto.getTitle());

        if (game == null) {
            System.out.println("Game with this title does not exist");
            return;
        }

        GameViewDetailDto gameDto = modelMapper.map(game, GameViewDetailDto.class);

        System.out.println("Title: " + gameDto.getTitle());
        System.out.println("Price: " + gameDto.getPrice());
        System.out.println("Description: " + gameDto.getDescription());
        System.out.println("Release date: " + gameDto.getReleaseDate());
    }
}
