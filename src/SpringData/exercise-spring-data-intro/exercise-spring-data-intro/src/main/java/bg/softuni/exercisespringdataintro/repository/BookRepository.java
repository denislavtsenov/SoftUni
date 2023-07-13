package bg.softuni.exercisespringdataintro.repository;

import bg.softuni.exercisespringdataintro.models.AgeRestriction;
import bg.softuni.exercisespringdataintro.models.Book;
import bg.softuni.exercisespringdataintro.models.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate releaseDate, LocalDate releaseDate2);

    List<Book> findAllByTitleContains(String containingString);

    List<Book> findAllByAuthorLastNameStartsWith(String inputString);

    @Query("SELECT b FROM Book b WHERE length(b.title) > :number")
    List<Book> findAllByTitleLengthGreaterThan(int number);


}
