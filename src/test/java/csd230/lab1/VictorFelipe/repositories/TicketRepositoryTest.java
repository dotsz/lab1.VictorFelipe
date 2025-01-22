package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Ticket;
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
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testCreateTicket() {
        // Arrange
        Ticket ticket = new Ticket();
        ticket.setText("Sample Ticket Text");

        // Act
        ticketRepository.save(ticket);

        // Assert
        assertNotNull(ticket.getId());
        assertTrue(ticketRepository.findById(ticket.getId()).isPresent());
    }

    @Test
    void testReadTicket() {
        // Arrange
        Ticket ticket = new Ticket();
        ticket.setText("Another Ticket Text");
        ticketRepository.save(ticket);

        // Act
        Ticket foundTicket = ticketRepository.findById(ticket.getId()).orElse(null);

        // Assert
        assertNotNull(foundTicket);
        assertEquals("Another Ticket Text", foundTicket.getText());
    }

    @Test
    void testUpdateTicket() {
        // Arrange
        Ticket ticket = new Ticket();
        ticket.setText("Initial Text");
        ticketRepository.save(ticket);

        // Act
        ticket.setText("Updated Text");
        ticketRepository.save(ticket);
        Ticket updatedTicket = ticketRepository.findById(ticket.getId()).orElse(null);

        // Assert
        assertNotNull(updatedTicket);
        assertEquals("Updated Text", updatedTicket.getText());
    }

    @Test
    void testDeleteTicket() {
        // Arrange
        Ticket ticket = new Ticket();
        ticket.setText("To Be Deleted");
        ticketRepository.save(ticket);

        // Act
        ticketRepository.deleteById(ticket.getId());
        boolean exists = ticketRepository.existsById(ticket.getId());

        // Assert
        assertFalse(exists);
    }

    @Test
    void testTicketToString() {
        // Arrange
        Ticket ticket = new Ticket();
        ticket.setText("ToString Test");

        // Act
        String ticketString = ticket.toString();

        // Assert
        assertEquals("Ticket { ToString Test }", ticketString);
    }

    @Test
    void testTicketEqualsAndHashCode() {
        // Arrange
        Ticket ticket1 = new Ticket();
        ticket1.setText("Same Text");

        Ticket ticket2 = new Ticket();
        ticket2.setText("Same Text");

        // Act & Assert
        assertEquals(ticket1, ticket2);
        assertEquals(ticket1.hashCode(), ticket2.hashCode());

        ticket2.setText("Different Text");

        assertNotEquals(ticket1, ticket2);
        assertNotEquals(ticket1.hashCode(), ticket2.hashCode());
    }
}
