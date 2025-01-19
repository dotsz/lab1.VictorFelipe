package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByISBN(String isbn);

    Book findById(long id);

    List<Book> findByTitleContainingIgnoreCase(String keyword);

    List<Book> findByAuthorContainingIgnoreCase(String keyword);

    @Query("SELECT b FROM Book b WHERE b.price BETWEEN :minPrice AND :maxPrice")
    List<Book> findByPriceRange(double min, double max);

  }