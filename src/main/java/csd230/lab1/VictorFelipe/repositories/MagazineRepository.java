package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Date;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    List<Magazine> findByOrderQtyGreaterThan(int orderQty);

    List<Magazine> findByCurrIssueBefore(Date date);

    @Query("SELECT m FROM Magazine m WHERE m.description LIKE %:keyword%")
    List<Magazine> findByDescriptionKeyword(String keyword);

    List<Magazine> findByTitle(String title);

    List<Magazine> findByTitleContainingIgnoreCase(String keyword);
}