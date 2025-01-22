package csd230.lab1.VictorFelipe.repositories;

import csd230.lab1.VictorFelipe.entities.Cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testSaveCart() {
        // Given
        Cart cart = new Cart();
        // When
        Cart savedCart = cartRepository.save(cart);

        // Then
        assert savedCart.getId() != null;
    }
}
