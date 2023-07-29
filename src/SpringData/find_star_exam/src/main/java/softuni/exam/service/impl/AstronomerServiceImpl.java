package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDto;
import softuni.exam.models.dto.AstronomerWrapperDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

import static softuni.exam.models.Constants.*;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static String ASTRONOMERS_PATH_FILE = "src/main/resources/files/xml/astronomers.xml";
    private AstronomerRepository astronomerRepository;
    private StarRepository starRepository;
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    private ValidationUtil validationUtil;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_PATH_FILE));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<AstronomerImportDto> astronomers = this.xmlParser.fromFile(ASTRONOMERS_PATH_FILE, AstronomerWrapperDto.class)
                .getAstronomers();

        for (AstronomerImportDto astronomer : astronomers) {
            stringBuilder.append(System.lineSeparator());

            if (this.astronomerRepository.findFirstByFirstNameAndLastName(astronomer.getFirstName(), astronomer.getLastName()).isPresent()
                    || !this.starRepository.findById(astronomer.getStarId()).isPresent()
            || !this.validationUtil.isValid(astronomer)) {

                stringBuilder.append(String.format(INVALID_FORMAT, ASTRONOMER));
                continue;
            }

            this.astronomerRepository.save(modelMapper.map(astronomer, Astronomer.class));

            stringBuilder.append(String.format(Locale.US, SUCCESSFUL_FORMAT_ASTRONOMER,
                    astronomer.getFirstName(),
                    astronomer.getLastName(),
                    astronomer.getAverageObservationHours()));
        }


        return stringBuilder.toString().trim();
    }
}
