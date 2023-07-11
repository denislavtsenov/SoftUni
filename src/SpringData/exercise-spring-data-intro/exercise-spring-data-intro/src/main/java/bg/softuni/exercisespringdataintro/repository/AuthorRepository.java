package bg.softuni.exercisespringdataintro.repository;

import bg.softuni.exercisespringdataintro.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
