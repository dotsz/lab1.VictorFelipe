package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByText(String text);
    List<Ticket> findByTextContaining(String keyword);
}