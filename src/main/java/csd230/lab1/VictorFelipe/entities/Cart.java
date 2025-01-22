package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // linkedhashset for NO duplicate items
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> items = new LinkedHashSet<>();

    public Set<CartItem> getItems() {
        return items;
    }

    public Cart() {
    }

    public Cart(Long id, Set<CartItem> items) {
        this.id = id;
        this.items = items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void addItem(CartItem item) {
        item.setCart(this);
        items.add(item);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return id.equals(cart.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}