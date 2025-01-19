package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByPrice(double price);
    CartItem findById(long id);
    List<CartItem> findByDescriptionContaining(String keyword);
    List<CartItem> findByPriceGreaterThan(double price);
    List<CartItem> findByPriceLessThan(double price);


}