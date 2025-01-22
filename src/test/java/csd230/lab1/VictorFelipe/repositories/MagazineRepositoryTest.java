package csd230.lab1.VictorFelipe.repositories;

import com.github.javafaker.Faker;
import csd230.lab1.VictorFelipe.entities.Magazine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MagazineRepositoryTest {

    @Autowired
    private MagazineRepository magazineRepository;

    private final Faker faker = new Faker();

    @Test
    void testCreateMagazine() {
        // Arrange
        Magazine magazine = new Magazine();
        magazine.setTitle(faker.book().title());
        magazine.setOrderQty(5);
        magazine.setCurrIssue(new Date());

        // Act
        magazineRepository.save(magazine);

        // Assert
        assertNotNull(magazine.getId());
        assertTrue(magazineRepository.findById(magazine.getId()).isPresent());
    }

    @Test
    void testReadMagazine() {
        // Arrange
        Magazine magazine = new Magazine();
        magazine.setTitle(faker.book().title());
        magazine.setOrderQty(10);
        magazine.setCurrIssue(new Date());
        magazineRepository.save(magazine);

        // Act
        Magazine foundMagazine = magazineRepository.findById(magazine.getId()).orElse(null);

        // Assert
        assertNotNull(foundMagazine);
        assertEquals(magazine.getTitle(), foundMagazine.getTitle());
        assertEquals(magazine.getOrderQty(), foundMagazine.getOrderQty());
        assertEquals(magazine.getCurrIssue(), foundMagazine.getCurrIssue());
    }

    @Test
    void testUpdateMagazine() {
        // Arrange
        Magazine magazine = new Magazine();
        magazine.setTitle(faker.book().title());
        magazine.setOrderQty(15);
        magazine.setCurrIssue(new Date());
        magazineRepository.save(magazine);

        // Act
        magazine.setTitle("Updated Title");
        magazine.setOrderQty(20);
        magazineRepository.save(magazine);
        Magazine updatedMagazine = magazineRepository.findById(magazine.getId()).orElse(null);

        // Assert
        assertNotNull(updatedMagazine);
        assertEquals("Updated Title", updatedMagazine.getTitle());
        assertEquals(20, updatedMagazine.getOrderQty());
    }

    @Test
    void testDeleteMagazine() {
        // Arrange
        Magazine magazine = new Magazine();
        magazine.setTitle(faker.book().title());
        magazine.setOrderQty(8);
        magazine.setCurrIssue(new Date());
        magazineRepository.save(magazine);

        // Act
        magazineRepository.deleteById(magazine.getId());
        boolean exists = magazineRepository.existsById(magazine.getId());

        // Assert
        assertFalse(exists);
    }
}
