package softuni.exam.models.dto;

import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;

import java.util.Locale;

public class StarViewDto {

    private Star star;
    private Constellation constellation;

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {

        String FORMAT = "Star: %s\n" +
                "   *Distance: %.2f light years\n" +
                "   **Description: %s\n" +
                "   ***Constellation: %s\n";


        return String.format(Locale.US, FORMAT,
                star.getName(),
                star.getLightYears(),
                star.getDescription(),
                constellation.getName());
    }
}
