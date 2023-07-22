package bg.softuni.jsonprocessing.model.dto;

import bg.softuni.jsonprocessing.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserSeedDto {
    private String firstName;

    @Size(min = 3)
    private String lastName;
    private Integer age;
    private User friend;

    public UserSeedDto() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
