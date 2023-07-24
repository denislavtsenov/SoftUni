package bg.softuni.jsonprocessingcardealer.repository;

import bg.softuni.jsonprocessingcardealer.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
