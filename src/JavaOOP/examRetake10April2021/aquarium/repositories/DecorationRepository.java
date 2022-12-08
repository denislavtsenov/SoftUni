package JavaOOP.examRetake10April2021.aquarium.repositories;

import JavaOOP.examRetake10April2021.aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        decorations = new ArrayList<>();
    }

    protected Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(decorations);
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        return decorations.stream().filter(f -> f.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
