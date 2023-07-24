package bg.softuni.jsonprocessingcardealer.service.impl;

import bg.softuni.jsonprocessingcardealer.model.dto.PartSeedDto;
import bg.softuni.jsonprocessingcardealer.model.entity.Car;
import bg.softuni.jsonprocessingcardealer.model.entity.Part;
import bg.softuni.jsonprocessingcardealer.repository.PartRepository;
import bg.softuni.jsonprocessingcardealer.service.CarService;
import bg.softuni.jsonprocessingcardealer.service.PartService;
import bg.softuni.jsonprocessingcardealer.service.SupplierService;
import bg.softuni.jsonprocessingcardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private static final String PARTS_FILE_PATH = "src/main/resources/files/parts.json";

    private final PartRepository partRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, SupplierService supplierService, CarService carService) {
        this.partRepository = partRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }

    @Override
    public void seedParts() throws IOException {

        if (partRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(PARTS_FILE_PATH));

        PartSeedDto[] partSeedDtos = gson.fromJson(fileContent, PartSeedDto[].class);

        Arrays.stream(partSeedDtos)
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());

                    return part;
                })
                .forEach(partRepository::save);

    }

    @Override
    public Set<Part> getRandomPart() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, partRepository.count() + 1);

        Set<Part> parts = new HashSet<>();
        parts.add(partRepository.findById(randomId).orElse(null));

        return parts;
    }
}
