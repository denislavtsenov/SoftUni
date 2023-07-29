package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.dto.StarViewDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class StarServiceImpl implements StarService {

    private static String STARS_PATH_FILE = "src/main/resources/files/json/stars.json";

    private final ConstellationRepository constellationRepository;
    private final AstronomerRepository astronomerRepository;
    private StarRepository starRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private Gson gson;

    public StarServiceImpl(ConstellationRepository constellationRepository, AstronomerRepository astronomerRepository, StarRepository starRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_PATH_FILE));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<StarImportDto> stars = Arrays.stream(this.gson.fromJson(readStarsFileContent(), StarImportDto[].class))
                .collect(Collectors.toList());

        for (StarImportDto star : stars) {
            stringBuilder.append(System.lineSeparator());

            Optional<Constellation> constellation = constellationRepository.findById(star.getConstellation());
            if(constellation.isEmpty()){
                continue;
            }
            if (this.starRepository.findFirstByName(star.getName()).isPresent()
                    || !this.validationUtil.isValid(star)) {

                stringBuilder.append(String.format(INVALID_FORMAT, STAR));
                continue;
            }
            Star starToSave = modelMapper.map(star, Star.class);
            starToSave.setConstellation(constellation.get());

            this.starRepository.save(starToSave);

            stringBuilder.append(String.format(Locale.US, SUCCESSFUL_FORMAT_STAR,
                    star.getName(),
                    star.getLightYears()));

        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportStars() {

       return starRepository.findAllByStarTypeAndAstronomersIsEmptyOrderByLightYears(StarType.RED_GIANT)
               .stream()
               .map(star -> this.modelMapper.map(star, StarViewDto.class))
               .map(StarViewDto::toString)
               .collect(Collectors.joining())
               .trim();
    }
}
