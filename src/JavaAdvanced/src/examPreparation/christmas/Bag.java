package JavaAdvanced.src.examPreparation.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (data.size() < getCapacity()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
         return data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviestPresent =
        data.stream().max(Comparator.comparingDouble(Present::getWeight)).get();
        return heaviestPresent;
    }

    public Present getPresent(String name) {
        return data.stream().filter(present -> present.getName().equals(name))
                .findFirst().get();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s bag contains:%n", getColor()));

        for (Present present : data) {
            stringBuilder.append(String.format("%s%n", present));
        }

        return stringBuilder.toString();
    }

}
