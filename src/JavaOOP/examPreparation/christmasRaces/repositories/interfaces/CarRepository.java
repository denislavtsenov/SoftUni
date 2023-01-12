package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarRepository implements Repository<Car> {

    private Map<String, Car> cars;

    public CarRepository() {
        cars = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return this.cars.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars.values());
    }

    @Override
    public void add(Car model) {
        this.cars.put(model.getModel(), model);
    }

    @Override
    public boolean remove(Car model) {
        return cars.values().remove(model);
    }
}
