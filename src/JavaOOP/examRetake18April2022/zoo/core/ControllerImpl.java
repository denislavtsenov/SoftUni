package JavaOOP.examRetake18April2022.zoo.core;

import JavaOOP.examRetake18April2022.zoo.entities.animals.Animal;
import JavaOOP.examRetake18April2022.zoo.entities.animals.AquaticAnimal;
import JavaOOP.examRetake18April2022.zoo.entities.animals.TerrestrialAnimal;
import JavaOOP.examRetake18April2022.zoo.entities.areas.Area;
import JavaOOP.examRetake18April2022.zoo.entities.areas.LandArea;
import JavaOOP.examRetake18April2022.zoo.entities.areas.WaterArea;
import JavaOOP.examRetake18April2022.zoo.entities.foods.Food;
import JavaOOP.examRetake18April2022.zoo.entities.foods.Meat;
import JavaOOP.examRetake18April2022.zoo.entities.foods.Vegetable;
import JavaOOP.examRetake18April2022.zoo.repositories.FoodRepository;
import JavaOOP.examRetake18April2022.zoo.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static JavaOOP.examRetake18April2022.zoo.common.ConstantMessages.*;
import static JavaOOP.examRetake18April2022.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {

        Area area;

        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }

        areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {

        Food food;

        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {

        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        Area area = areas.get(areaName);
        area.addFood(food);

        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {

        Animal animal;

        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal"))
            animal = new TerrestrialAnimal(animalName, kind, price);
        else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        Area area = areas.get(areaName);

        if (area.getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal")) {
            area.addAnimal(animal);
        } else if (area.getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal")) {
            area.addAnimal(animal);
        } else {
            return AREA_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);

    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.get(areaName);

        for (Animal a : area.getAnimals()) {
            a.eat();
        }

        return String.format(ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.get(areaName);
        double sumKg = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();

        return String.format(KILOGRAMS_AREA, areaName, sumKg);

    }

    @Override
    public String getStatistics() {
        return areas.values()
                .stream()
                .map(Area::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
