package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.dto.CarWrapperDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.models.Constants.*;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private CarsRepository carsRepository;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    private ValidationUtil validationUtil;

    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<CarImportDto> cars = this.xmlParser.fromFile(CARS_FILE_PATH, CarWrapperDto.class)
                .getCars();

        for (CarImportDto car : cars) {
            stringBuilder.append(System.lineSeparator());

            if (this.carsRepository.findFirstByPlateNumber(car.getPlateNumber()).isPresent()
                    || !this.validationUtil.isValid(car)) {

                stringBuilder.append(String.format(INVALID_FORMAT, CAR));
                continue;
            }

            this.carsRepository.save(this.modelMapper.map(car, Car.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, CAR,
                    car.getCarMake() + " -",
                    car.getCarModel()));
        }
        return stringBuilder.toString().trim();
    }
}
