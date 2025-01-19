package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public abstract class Publication extends CartItem {
    @Column(name = "title")
    private String title;

    @Column(name = "copies", nullable = false)
    private int copies = 1;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Publication { " + title + " (Copies: " + copies + ") }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication that)) return false;
        if (!super.equals(o)) return false;
        return getCopies() == that.getCopies() && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getCopies());
    }
}