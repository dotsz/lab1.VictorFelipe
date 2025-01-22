package csd230.lab1.VictorFelipe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class Magazine extends Publication {
    @Column(name = "order_qty", nullable = true)
    private int orderQty = 1;

    @Column(name = "curr_issue")
    private Date currIssue;

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }

    @Override
    public String toString() {
        return "Magazine { " + getTitle() + " (Order Qty: " + orderQty + ", Current Issue: " + currIssue + ") }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine magazine)) return false;
        if (!super.equals(o)) return false;
        return getOrderQty() == magazine.getOrderQty() && Objects.equals(getCurrIssue(), magazine.getCurrIssue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrderQty(), getCurrIssue());
    }
}