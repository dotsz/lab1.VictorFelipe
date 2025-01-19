package csd230.lab1.VictorFelipe.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.VictorFelipe.entities.Book}
 */
/**
 * DTO for {@link csd230.lab1.VictorFelipe.entities.Book}
 */
public class Book extends Publication {
    private String author;
    private String ISBN;
//    private String ISBN_10;
    public Book() {}

    public Book(double price, int quantity, String description, Cart cart, String title, int copies, String author, String ISBN) {
        super(price, quantity, description, cart, title, copies);
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(author, book.author) && Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, ISBN);
    }
}
