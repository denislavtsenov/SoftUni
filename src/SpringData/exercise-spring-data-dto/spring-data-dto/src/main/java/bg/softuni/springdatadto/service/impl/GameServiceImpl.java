package bg.softuni.springdatadto.service.impl;

import bg.softuni.springdatadto.model.dto.GameAddDto;
import bg.softuni.springdatadto.model.entity.Game;
import bg.softuni.springdatadto.repository.GameRepository;
import bg.softuni.springdatadto.service.GameService;
import bg.softuni.springdatadto.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
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
}
