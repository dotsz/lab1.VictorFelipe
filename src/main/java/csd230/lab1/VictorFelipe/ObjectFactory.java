package csd230.lab1.VictorFelipe;

import csd230.lab1.VictorFelipe.entities.Book;
import csd230.lab1.VictorFelipe.entities.Magazine;
import csd230.lab1.VictorFelipe.entities.DiscMag;
import csd230.lab1.VictorFelipe.entities.Ticket;

import com.github.javafaker.Faker;

public class ObjectFactory {
    private static final Faker faker = new Faker();


    public static Book createBook() {
        Book book = new Book();
        book.setTitle(faker.book().title());
        book.setISBN(faker.code().isbn10());
        book.setAuthor(faker.book().author());
        book.setQuantity(faker.number().numberBetween(1, 100));
        book.setPrice(faker.number().randomDouble(2, 10, 100));
        book.setCopies(faker.number().numberBetween(1, 100));
        book.setDescription(faker.lorem().sentence());
        return book;
    }

    public static Magazine createMagazine() {
        Magazine magazine = new Magazine();
        magazine.setTitle(faker.book().title());
        magazine.setCurrIssue(faker.date().birthday());
        magazine.setOrderQty(faker.number().numberBetween(1, 100));
        magazine.setPrice(faker.number().randomDouble(2, 10, 100));
        magazine.setDescription(faker.lorem().sentence());
        magazine.setCopies(faker.number().numberBetween(1, 100));
        magazine.setQuantity(faker.number().numberBetween(1, 100));
        return magazine;
    }

    public static DiscMag createDiscMag() {
        DiscMag discMag = new DiscMag();
        discMag.setTitle(faker.book().title());
        discMag.setHasDisc(faker.bool().bool());
        discMag.setOrderQty(faker.number().numberBetween(1, 100));
        discMag.setPrice(faker.number().randomDouble(2, 10, 100));
        discMag.setQuantity(faker.number().numberBetween(1, 100));
        discMag.setCopies(faker.number().numberBetween(1, 100));
        discMag.setCurrIssue(faker.date().past(365, java.util.concurrent.TimeUnit.DAYS));
        discMag.setDescription(faker.lorem().sentence());
        return discMag;
    }

    public static Ticket createTicket() {
        Ticket ticket = new Ticket();
        ticket.setText(faker.lorem().sentence());
        ticket.setPrice(faker.number().randomDouble(2, 10, 100));
        ticket.setDescription(faker.lorem().sentence());
        ticket.setQuantity(faker.number().numberBetween(1, 100));
        return ticket;
    }
}
