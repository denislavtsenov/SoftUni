package JavaOOP.examRetake10April2021.aquarium.repositories;

import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
