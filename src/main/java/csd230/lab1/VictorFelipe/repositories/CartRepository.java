package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
   Cart findById(long id);
}