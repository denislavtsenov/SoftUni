package bg.softuni.jsonprocessingcardealer.service;

import bg.softuni.jsonprocessingcardealer.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {
    void seedParts() throws IOException;

    Set<Part> getRandomPart();
}
