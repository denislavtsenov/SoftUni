package bg.softuni.jsonprocessingcardealer.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "traveled_distance")
    private Long travelledDistance;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Part> parts;

    public Car() {
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

    public void setTravelledDistance(Long traveledDistance) {
        this.travelledDistance = traveledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
