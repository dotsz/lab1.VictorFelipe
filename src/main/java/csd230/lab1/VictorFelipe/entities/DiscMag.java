package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class DiscMag extends Magazine {
    @Column(name = "has_disc")
    private boolean hasDisc;

    public boolean getHasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }

    @Override
    public String toString() {
        return "DiscMag { " + getTitle() + " (Order Qty: " + getOrderQty() + ", Current Issue: " + getCurrIssue() + ", Has Disc: " + hasDisc + ") }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscMag discMag)) return false;
        if (!super.equals(o)) return false;
        return getHasDisc() == discMag.getHasDisc();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHasDisc());
    }
}