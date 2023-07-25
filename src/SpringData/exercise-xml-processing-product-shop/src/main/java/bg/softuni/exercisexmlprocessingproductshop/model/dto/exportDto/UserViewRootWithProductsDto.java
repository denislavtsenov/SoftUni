package bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootWithProductsDto {

    @XmlElement(name = "user")
    List<UserWithAtLeastOneSoldProductDto> users;

    public List<UserWithAtLeastOneSoldProductDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithAtLeastOneSoldProductDto> users) {
        this.users = users;
    }
}
