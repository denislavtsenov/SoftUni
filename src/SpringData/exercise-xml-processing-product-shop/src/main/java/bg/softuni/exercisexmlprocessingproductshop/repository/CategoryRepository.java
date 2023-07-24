package bg.softuni.exercisexmlprocessingproductshop.repository;

import bg.softuni.exercisexmlprocessingproductshop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
