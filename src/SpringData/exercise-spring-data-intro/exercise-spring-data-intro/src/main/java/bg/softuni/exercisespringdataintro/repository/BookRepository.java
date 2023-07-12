package bg.softuni.exercisespringdataintro.repository;

import bg.softuni.exercisespringdataintro.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);
}
