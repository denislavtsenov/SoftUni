package bg.softuni.exercisespringdataintro.repositories;

import bg.softuni.exercisespringdataintro.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
