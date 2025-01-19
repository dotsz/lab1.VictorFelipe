package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Book extends Publication {
    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String ISBN;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book { " + getTitle() + " by " + author + " (ISBN: " + ISBN + ") }";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return author.equals(book.author) && ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + author.hashCode() + ISBN.hashCode();
    }

}