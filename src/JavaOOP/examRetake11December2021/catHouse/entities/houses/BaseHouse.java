package JavaOOP.examRetake11December2021.catHouse.entities.houses;

import JavaOOP.examRetake11December2021.catHouse.entities.cat.Cat;
import JavaOOP.examRetake11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static JavaOOP.examRetake11December2021.catHouse.common.ConstantMessages.*;
import static JavaOOP.examRetake11December2021.catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {

        if (this.cats.size() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        String catsReport = cats.isEmpty()
                ? "none"
                : cats.stream().map(Cat::getName)
                .collect(Collectors.joining(" "));

        sb.append(this.name).append(" ").append(getClass().getSimpleName()).append(":")
                .append(System.lineSeparator())
                .append("Cats: ").append(catsReport)
                .append(System.lineSeparator())
                .append("Toys: ").append(this.toys.size()).append(" ").append("Softness: ").append(sumSoftness());

        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
