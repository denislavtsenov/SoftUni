package bg.softuni.springdatadto.service;

import bg.softuni.springdatadto.model.dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long id, BigDecimal newPrice, Double newSize);
}
