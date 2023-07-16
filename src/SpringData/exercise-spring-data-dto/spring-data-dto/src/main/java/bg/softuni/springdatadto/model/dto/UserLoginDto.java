package bg.softuni.springdatadto.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserLoginDto {

    @Email
    private String email;

    @Pattern(regexp = "[A-Za-z0-9]{6,}")
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
