package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverRepository implements Repository<Driver> {
    Map<String, Driver> drivers;

    public DriverRepository() {
       this.drivers = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return this.drivers.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.drivers.values());
    }

    @Override
    public void add(Driver model) {
        this.drivers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.drivers.values().remove(model);
    }
}
