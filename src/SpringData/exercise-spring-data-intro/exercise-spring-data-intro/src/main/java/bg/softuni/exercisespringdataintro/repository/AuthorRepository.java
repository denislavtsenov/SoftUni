package bg.softuni.exercisespringdataintro.repository;

import bg.softuni.exercisespringdataintro.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY size(a.books) DESC")
    List<Author> findAllByBooksSizeOrderDesc();

    List<Author> findAllByFirstNameEndingWith(String endingString);

    @Query("SELECT a.firstName, a.lastName, SUM(b.copies) AS totalCopies " +
            "FROM Author AS a " +
            "JOIN a.books AS b " +
            "ORDER BY totalCopies DESC")
    List<Author> findAllByTotalCopies();


}
