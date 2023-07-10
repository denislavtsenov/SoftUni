package bg.softuni.exercisespringdataintro.repositories;

import bg.softuni.exercisespringdataintro.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
