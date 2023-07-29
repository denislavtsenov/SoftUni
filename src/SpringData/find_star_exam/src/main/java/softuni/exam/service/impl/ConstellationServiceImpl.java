package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";
    private ConstellationRepository constellationRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private Gson gson;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<ConstellationImportDto> constellations = Arrays.stream(this.gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class))
                .collect(Collectors.toList());

        for (ConstellationImportDto constellation : constellations) {
            stringBuilder.append(System.lineSeparator());

            if (this.constellationRepository.findFirstByName(constellation.getName()).isPresent()
                    || !validationUtil.isValid(constellation)) {

                stringBuilder.append(String.format(INVALID_FORMAT, CONSTELLATION));
                continue;
            }

            this.constellationRepository.save(this.modelMapper.map(constellation, Constellation.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT_CONSTELLATION,
                    constellation.getName(),
                    constellation.getDescription()));
        }

        return stringBuilder.toString().trim();
    }
}
