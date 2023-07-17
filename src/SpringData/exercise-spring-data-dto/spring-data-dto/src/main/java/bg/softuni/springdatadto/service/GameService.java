package bg.softuni.springdatadto.service;

import bg.softuni.springdatadto.model.dto.GameAddDto;
import bg.softuni.springdatadto.model.dto.GameViewDetailDto;
import bg.softuni.springdatadto.model.dto.GameViewPriceTitleDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long id, BigDecimal newPrice, Double newSize);

    void deleteGame(Long id);

    void printPriceAndTitleAllGames(GameViewPriceTitleDto gameViewPriceTitleDto);

    void printGameDetailsByTitle(GameViewDetailDto gameViewDetailDto);
}
