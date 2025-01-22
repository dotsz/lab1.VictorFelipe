package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.DiscMag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscMagRepository extends JpaRepository<DiscMag, Long> {
    List<DiscMag> findByHasDiscTrue();
    List<DiscMag> findByHasDiscFalse();

    List<DiscMag> findByHasDisc(boolean b);
}