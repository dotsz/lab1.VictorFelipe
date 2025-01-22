package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    void testCreateCartItem() {
        // Arrange
        CartItem cartItem = new CartItem();
        cartItem.setDescription("Test Item");
        cartItem.setPrice(29.99);
        cartItem.setQuantity(5);

        // Act
        CartItem savedCartItem = cartItemRepository.save(cartItem);

        // Assert
        assertNotNull(savedCartItem.getId());
        assertEquals("Test Item", savedCartItem.getDescription());
    }

    @Test
    void testReadCartItem() {
        // Arrange
        CartItem cartItem = new CartItem();
        cartItem.setDescription("Test Item");
        cartItem.setPrice(19.99);
        cartItem.setQuantity(3);
        cartItem = cartItemRepository.save(cartItem);

        // Act
        CartItem foundCartItem = cartItemRepository.findById(cartItem.getId()).orElse(null);

        // Assert
        assertNotNull(foundCartItem);
        assertEquals(cartItem.getId(), foundCartItem.getId());
    }

    @Test
    void testUpdateCartItem() {
        // Arrange
        CartItem cartItem = new CartItem();
        cartItem.setDescription("Old Item");
        cartItem.setPrice(15.99);
        cartItem.setQuantity(2);
        cartItem = cartItemRepository.save(cartItem);

        // Act
        cartItem.setDescription("Updated Item");
        cartItemRepository.save(cartItem);
        CartItem updatedCartItem = cartItemRepository.findById(cartItem.getId()).orElse(null);

        // Assert
        assertNotNull(updatedCartItem);
        assertEquals("Updated Item", updatedCartItem.getDescription());
    }

    @Test
    void testDeleteCartItem() {
        // Arrange
        CartItem cartItem = new CartItem();
        cartItem.setDescription("Test Item");
        cartItem.setPrice(29.99);
        cartItem.setQuantity(5);
        cartItem = cartItemRepository.save(cartItem);

        // Act
        cartItemRepository.deleteById(cartItem.getId());
        boolean exists = cartItemRepository.existsById(cartItem.getId());

        // Assert
        assertFalse(exists);
    }

}
