package bg.softuni.springdatadto.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameViewDetailDto {

    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameViewDetailDto() {
    }

    public String getTitle() {
        return title;
    }

    public GameViewDetailDto(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
