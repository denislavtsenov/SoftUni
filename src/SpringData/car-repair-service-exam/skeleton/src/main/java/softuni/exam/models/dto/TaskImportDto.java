package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

    @NotNull
    @XmlElement
    private String date;

    @NotNull
    @Positive
    @XmlElement
    private BigDecimal price;

    @NotNull
    @XmlElement
    private CarBaseDto car;

    @NotNull
    @XmlElement
    private MechanicBaseDto mechanic;

    @NotNull
    @XmlElement
    private PartBaseDto part;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarBaseDto getCar() {
        return car;
    }

    public void setCar(CarBaseDto car) {
        this.car = car;
    }

    public MechanicBaseDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBaseDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartBaseDto getPart() {
        return part;
    }

    public void setPart(PartBaseDto part) {
        this.part = part;
    }
}
