package csd230.lab1.VictorFelipe.repositories;

import com.github.javafaker.Faker;
import csd230.lab1.VictorFelipe.entities.DiscMag;
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
public class DiscMagRepositoryTest {

    @Autowired
    private DiscMagRepository discMagRepository;

    private final Faker faker = new Faker();

    @Test
    void testCreateDiscMag() {
        // Arrange
        DiscMag discMag = new DiscMag();
        discMag.setTitle(faker.book().title());
        discMag.setOrderQty(10);
        discMag.setCurrIssue(new Date());
        discMag.setHasDisc(true);

        // Act
        discMagRepository.save(discMag);

        // Assert
        assertNotNull(discMag.getId());
        assertTrue(discMagRepository.findById(discMag.getId()).isPresent());
    }

    @Test
    void testReadDiscMag() {
        // Arrange
        DiscMag discMag = new DiscMag();
        discMag.setTitle(faker.book().title());
        discMag.setOrderQty(5);
        discMag.setCurrIssue(new Date());
        discMag.setHasDisc(true);
        discMagRepository.save(discMag);

        // Act
        DiscMag foundDiscMag = discMagRepository.findById(discMag.getId()).orElse(null);

        // Assert
        assertNotNull(foundDiscMag);
        assertEquals(discMag.getTitle(), foundDiscMag.getTitle());
        assertEquals(discMag.getOrderQty(), foundDiscMag.getOrderQty());
        assertEquals(discMag.getCurrIssue(), foundDiscMag.getCurrIssue());
        assertTrue(foundDiscMag.getHasDisc());
    }

    @Test
    void testUpdateDiscMag() {
        // Arrange
        DiscMag discMag = new DiscMag();
        discMag.setTitle(faker.book().title());
        discMag.setOrderQty(7);
        discMag.setCurrIssue(new Date());
        discMag.setHasDisc(false);
        discMagRepository.save(discMag);

        // Act
        discMag.setTitle("Updated DiscMag Title");
        discMag.setHasDisc(true);
        discMagRepository.save(discMag);
        DiscMag updatedDiscMag = discMagRepository.findById(discMag.getId()).orElse(null);

        // Assert
        assertNotNull(updatedDiscMag);
        assertEquals("Updated DiscMag Title", updatedDiscMag.getTitle());
        assertTrue(updatedDiscMag.getHasDisc());
    }

    @Test
    void testDeleteDiscMag() {
        // Arrange
        DiscMag discMag = new DiscMag();
        discMag.setTitle(faker.book().title());
        discMag.setOrderQty(6);
        discMag.setCurrIssue(new Date());
        discMag.setHasDisc(false);
        discMagRepository.save(discMag);

        // Act
        discMagRepository.deleteById(discMag.getId());
        boolean exists = discMagRepository.existsById(discMag.getId());

        // Assert
        assertFalse(exists);
    }
}
