package JavaOOP.examRetake09April2022.fairyShop.repositories;

import JavaOOP.examRetake09April2022.fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HelperRepository<T> implements Repository<Helper>{
    private List<Helper> helpers = new ArrayList<>();


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper model) {

        if (!helpers.contains(model)) {
            helpers.add(model);
        }
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model);
    }

    @Override
    public Helper findByName(String name) {
        return helpers.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }
}
