package bg.softuni.jsonprocessing.model.dto;

import jakarta.validation.constraints.Size;

public class CategorySeedDto {

    @Size(min = 3, max = 15)
    private String name;

    public CategorySeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
