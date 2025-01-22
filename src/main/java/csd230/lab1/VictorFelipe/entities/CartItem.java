package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "price", nullable = true)
    private double price;

    @Column(name = "quantity", nullable = true)
    private int quantity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartItem() {
    }

    public CartItem(double price, int quantity, String description) {
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", cart=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CartItem cartItem)) return false;
        return Double.compare(getPrice(), cartItem.getPrice()) == 0 && getQuantity() == cartItem.getQuantity() && Objects.equals(getId(), cartItem.getId()) && Objects.equals(getDescription(), cartItem.getDescription()) && Objects.equals(getCart(), cartItem.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getQuantity(), getDescription(), getCart());
    }
}