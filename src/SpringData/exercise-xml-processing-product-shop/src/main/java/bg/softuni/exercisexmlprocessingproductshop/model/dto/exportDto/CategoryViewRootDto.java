package bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewRootDto {

    @XmlElement(name = "category")
    List<CategoryViewDto> categories;

    public List<CategoryViewDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewDto> categories) {
        this.categories = categories;
    }
}
