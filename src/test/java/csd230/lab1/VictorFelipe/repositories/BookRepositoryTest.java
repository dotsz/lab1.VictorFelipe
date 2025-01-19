package csd230.lab1.VictorFelipe.repositories;

import com.github.javafaker.Faker;
import csd230.lab1.VictorFelipe.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private final Faker faker = new Faker();
    // Arrange-Act-Assert pattern
    @Test
    void testCreateBook() {
        // Arrange
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setAuthor(faker.book().author());
        book.setISBN(faker.code().isbn10());
        book.setQuantity(10);
        book.setPrice(19.99);

        // Act
        bookRepository.save(book);

        // Assert
        assertNotNull(book.getId());
        assertTrue(bookRepository.findById(book.getId()).isPresent());
    }

    @Test
    void testReadBook() {
        // Arrange
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setAuthor(faker.book().author());
        book.setISBN(faker.code().isbn10());
        book.setQuantity(10);
        book.setPrice(19.99);
        bookRepository.save(book);

        // Act
        Book foundBook = bookRepository.findById(book.getId()).orElse(null);

        // Assert
        assertNotNull(foundBook);
        assertEquals(book.getTitle(), foundBook.getTitle());
    }

    @Test
    void testUpdateBook() {
        // Arrange
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setAuthor(faker.book().author());
        book.setISBN(faker.code().isbn10());
        book.setQuantity(10);
        book.setPrice(19.99);
        bookRepository.save(book);

        // Act
        book.setTitle("Updated Title");
        bookRepository.save(book);
        Book updatedBook = bookRepository.findById(book.getId()).orElse(null);

        // Assert
        assertNotNull(updatedBook);
        assertEquals("Updated Title", updatedBook.getTitle());
    }

    @Test
    void testDeleteBook() {
        // Arrange
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setAuthor(faker.book().author());
        book.setISBN(faker.code().isbn10());
        book.setQuantity(10);
        book.setPrice(19.99);
        bookRepository.save(book);

        // Act
        bookRepository.deleteById(book.getId());
        boolean exists = bookRepository.existsById(book.getId());

        // Assert
        assertFalse(exists);
    }
}
