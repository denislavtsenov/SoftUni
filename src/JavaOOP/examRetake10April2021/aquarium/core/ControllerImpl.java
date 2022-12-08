package JavaOOP.examRetake10April2021.aquarium.core;

import JavaOOP.examRetake10April2021.aquarium.entities.aquariums.Aquarium;
import JavaOOP.examRetake10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import JavaOOP.examRetake10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Decoration;
import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Ornament;
import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Plant;
import JavaOOP.examRetake10April2021.aquarium.entities.fish.Fish;
import JavaOOP.examRetake10April2021.aquarium.entities.fish.FreshwaterFish;
import JavaOOP.examRetake10April2021.aquarium.entities.fish.SaltwaterFish;
import JavaOOP.examRetake10April2021.aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static JavaOOP.examRetake10April2021.aquarium.common.ConstantMessages.*;
import static JavaOOP.examRetake10April2021.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    DecorationRepository decorationRepository;
    Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        decorationRepository = new DecorationRepository();
        aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        aquariums.put(aquariumName, aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorationRepository.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorationRepository.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = aquariums.get(aquariumName);
        aquarium.addDecoration(decoration);
        decorationRepository.remove(decoration);


        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        Fish fish;

        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = aquariums.get(aquariumName);

        if (fishType.equals("FreshwaterFish") && aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
                aquarium.addFish(fish);
        } else if (fishType.equals("SaltwaterFish") && aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
                aquarium.addFish(fish);
        } else {
            throw new IllegalArgumentException(WATER_NOT_SUITABLE);
        }


        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.get(aquariumName);
        aquarium.feed();

        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {

        Aquarium aquarium = aquariums.get(aquariumName);

        double valueOfFish = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double valueOfDecor = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double value = valueOfFish + valueOfDecor;

        return String.format(VALUE_AQUARIUM, aquariumName, value);
    }

    @Override
    public String report() {
        return aquariums.values()
                .stream().map(Aquarium::getInfo)
                .collect(Collectors.joining(System.lineSeparator())).trim();

    }
}
