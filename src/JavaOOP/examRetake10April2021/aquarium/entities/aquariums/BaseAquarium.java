package JavaOOP.examRetake10April2021.aquarium.entities.aquariums;

import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Decoration;
import JavaOOP.examRetake10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static JavaOOP.examRetake10April2021.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static JavaOOP.examRetake10April2021.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();
        fish = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {

        if (this.fish.size() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        capacity -= 1;
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
        capacity += 1;

    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        String fishReport = fish.isEmpty()
                ? "none"
                : fish.stream()
                .map(Fish::getName)
                .collect(Collectors.joining(" "));

        sb.append(name).append(" ").append("(").append(getClass().getSimpleName()).append("):")
                .append(System.lineSeparator())
                .append("Fish: ").append(fishReport)
                .append(System.lineSeparator())
                .append("Decorations: ").append(decorations.size())
                .append(System.lineSeparator())
                .append("Comfort: ").append(calculateComfort());

        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
