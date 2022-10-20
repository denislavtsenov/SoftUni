package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();
        data.forEach(i -> {
            if (i.getSpecies().equals(species)) {
                i.setAvailable(false);
                toReturn.add(i);
            }
        });

        for (Parrot parrot : toReturn) {
            data.remove(parrot);
        }

        return toReturn;
    }

    public Parrot sellParrot(String name) {
      Parrot parrot = null;
        for (Parrot p : data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                data.remove(p);
                return p;
            }
        }
        return parrot;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", name )).append(System.lineSeparator());

        for (Parrot parrot : data) {
            sb.append(String.format("%s%n", parrot.toString()));
        }
        return sb.toString().trim();
    }


}
