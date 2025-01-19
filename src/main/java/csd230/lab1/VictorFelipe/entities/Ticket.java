package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Ticket extends CartItem {
    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Ticket { " + text + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getText(), ticket.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getText());
    }
}