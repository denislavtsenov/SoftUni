package bg.softuni.jsonprocessing.model.dto;

import java.util.Set;

public class UserSoldDto {

    private String firstname;
    private String lastname;
    private Set<SoldProductDto> soldProducts;

    public UserSoldDto() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<SoldProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
