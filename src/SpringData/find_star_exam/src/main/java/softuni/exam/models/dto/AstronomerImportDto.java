package softuni.exam.models.dto;

import softuni.exam.models.entity.Star;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDto {

    @NotNull
    @XmlElement(name = "average_observation_hours")
    @DecimalMin(value = "500.00")
    private Double averageObservationHours;

    @XmlElement(name = "birthday")
    private String birthDay;

    @NotNull
    @XmlElement(name = "first_name")
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @XmlElement(name = "last_name")
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @XmlElement(name = "salary")
    @DecimalMin(value = "15000.00")
    private Double salary;

    @NotNull
    @XmlElement(name = "observing_star_id")
    private Long starId;

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }
}
