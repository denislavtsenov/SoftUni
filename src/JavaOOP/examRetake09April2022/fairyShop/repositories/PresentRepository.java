package JavaOOP.examRetake09April2022.fairyShop.repositories;

import JavaOOP.examRetake09April2022.fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository<T> implements Repository<Present> {
    private Collection<Present> presents = new ArrayList<>();


    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    @Override
    public void add(Present model) {

        if (!presents.contains(model)) {
            presents.add(model);
        }

    }

    @Override
    public boolean remove(Present model) {
        return presents.remove(model);
    }

    @Override
    public Present findByName(String name) {
        return presents.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }
}
