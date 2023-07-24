package bg.softuni.jsonprocessingcardealer.service.impl;

import bg.softuni.jsonprocessingcardealer.model.dto.CarSeedDto;
import bg.softuni.jsonprocessingcardealer.model.entity.Car;
import bg.softuni.jsonprocessingcardealer.repository.CarRepository;
import bg.softuni.jsonprocessingcardealer.service.CarService;
import bg.softuni.jsonprocessingcardealer.service.PartService;
import bg.softuni.jsonprocessingcardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    private final static String CARS_FILE_PATH = "src/main/resources/files/cars.json";
    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, PartService partService) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.partService = partService;
    }

    @Override
    public void seedCars() throws IOException {

        if (carRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(CARS_FILE_PATH));

        CarSeedDto[] carSeedDtos = gson.fromJson(fileContent, CarSeedDto[].class);

        Arrays.stream(carSeedDtos)
                .map(carSeedDto -> {
                    carSeedDto.setParts(partService.getRandomPart());
                    return modelMapper.map(carSeedDto, Car.class);
                })
                .forEach(carRepository::save);

    }
}
