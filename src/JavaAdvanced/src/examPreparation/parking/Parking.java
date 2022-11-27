package JavaAdvanced.src.examPreparation.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n", type));

        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }

        return data.stream().max(Comparator.comparingInt(Car::getYear)).get();
    }
}
