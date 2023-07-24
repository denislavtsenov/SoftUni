package bg.softuni.jsonprocessingcardealer.model.dto;

import bg.softuni.jsonprocessingcardealer.model.entity.Part;

import java.util.Set;

public class CarSeedDto {

    private String make;
    private String model;
    private Long travelledDistance;

    private Set<Part> parts;

    public CarSeedDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
