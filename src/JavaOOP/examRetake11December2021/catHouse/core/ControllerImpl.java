package JavaOOP.examRetake11December2021.catHouse.core;

import JavaOOP.examRetake11December2021.catHouse.entities.cat.Cat;
import JavaOOP.examRetake11December2021.catHouse.entities.cat.LonghairCat;
import JavaOOP.examRetake11December2021.catHouse.entities.cat.ShorthairCat;
import JavaOOP.examRetake11December2021.catHouse.entities.houses.House;
import JavaOOP.examRetake11December2021.catHouse.entities.houses.LongHouse;
import JavaOOP.examRetake11December2021.catHouse.entities.houses.ShortHouse;
import JavaOOP.examRetake11December2021.catHouse.entities.toys.Ball;
import JavaOOP.examRetake11December2021.catHouse.entities.toys.Mouse;
import JavaOOP.examRetake11December2021.catHouse.entities.toys.Toy;
import JavaOOP.examRetake11December2021.catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static JavaOOP.examRetake11December2021.catHouse.common.ConstantMessages.*;
import static JavaOOP.examRetake11December2021.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {

        House house;

        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        this.houses.put(name, house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {

        Toy toy;

        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = houses.get(houseName);

        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat;

        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = houses.get(houseName);

        if (catType.equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse")) {
            house.getCats().add(cat);
        } else if (catType.equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse")) {
            house.getCats().add(cat);
        } else {
            return UNSUITABLE_HOUSE;
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.get(houseName);
        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.get(houseName);

        double sumOfCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumOfToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double value = sumOfCats + sumOfToys;

        return String.format(VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        return houses.values()
                .stream().map(House::getStatistics)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
