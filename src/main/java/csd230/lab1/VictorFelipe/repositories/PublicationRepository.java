package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByTitle(String title);
    List<Publication> findByCopiesGreaterThan(int copies);

}