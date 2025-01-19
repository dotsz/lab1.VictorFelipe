package csd230.lab1.VictorFelipe.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.VictorFelipe.entities.Ticket}
 */
public class Ticket extends CartItem {
    private String text;
    public Ticket() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void sellItem() {
        System.out.println(getDescription());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ticket ticket)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(text, ticket.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }
}