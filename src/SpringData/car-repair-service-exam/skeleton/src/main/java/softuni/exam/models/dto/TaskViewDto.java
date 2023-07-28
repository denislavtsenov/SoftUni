package softuni.exam.models.dto;

import java.math.BigDecimal;
import java.util.Locale;

public class TaskViewDto {

    private Long id;
    private BigDecimal price;
    private MechanicViewDto mechanic;
    private CarViewDto car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MechanicViewDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicViewDto mechanic) {
        this.mechanic = mechanic;
    }

    public CarViewDto getCar() {
        return car;
    }

    public void setCar(CarViewDto car) {
        this.car = car;
    }

    @Override
    public String toString() {

        String FORMAT = "Car %s %s with %dkm\n" +
                "-Mechanic: %s %s - task №%d:\n" +
                " --Engine: %.1f\n" +
                "---Price: %s$\n";

        return String.format(Locale.US, FORMAT,
                this.car.getCarMake(),
                this.car.getCarModel(),
                this.car.getKilometers(),
                this.mechanic.getFirstName(),
                this.mechanic.getLastName(),
                this.id,
                this.car.getEngine(),
                this.price.setScale(2));
    }
}
