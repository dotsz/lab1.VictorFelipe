package csd230.lab1.VictorFelipe;



import csd230.lab1.VictorFelipe.entities.Book;
import csd230.lab1.VictorFelipe.entities.DiscMag;
import csd230.lab1.VictorFelipe.entities.Magazine;
import csd230.lab1.VictorFelipe.entities.Ticket;
import csd230.lab1.VictorFelipe.repositories.BookRepository;
import csd230.lab1.VictorFelipe.repositories.DiscMagRepository;
import csd230.lab1.VictorFelipe.repositories.MagazineRepository;
import csd230.lab1.VictorFelipe.repositories.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final DiscMagRepository discMagRepository;
	private final MagazineRepository magazineRepository;
	private final TicketRepository ticketRepository;


	public Application(BookRepository bookRepository, DiscMagRepository discMagRepository, MagazineRepository magazineRepository, TicketRepository ticketRepository) {
		this.bookRepository = bookRepository;
		this.discMagRepository = discMagRepository;
		this.magazineRepository = magazineRepository;
		this.ticketRepository = ticketRepository;
	}


	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		BookRepository bookRepository = this.bookRepository;
		DiscMagRepository discMagRepository = this.discMagRepository;
		MagazineRepository magazineRepository = this.magazineRepository;
		TicketRepository ticketRepository = this.ticketRepository;

		// CREATE entities and save them to the database
		try {
			// Create books
			for (int i = 0; i < 10; i++) {
				Book book = ObjectFactory.createBook();
				bookRepository.save(book);
			}

			// Create magazines
			for (int i = 0; i < 10; i++) {
				Magazine magazine = ObjectFactory.createMagazine();
				magazineRepository.save(magazine);
			}

			// Create discMags
			for (int i = 0; i < 10; i++) {
				DiscMag discMag = ObjectFactory.createDiscMag();
				discMagRepository.save(discMag);
			}

			// Create tickets
			for (int i = 0; i < 10; i++) {
				Ticket ticket = ObjectFactory.createTicket();
				ticketRepository.save(ticket);
			}
		}
		catch (Exception e) {
			throw new Exception("Error creating entities", e);
		}

		// READ entities from the database
		try {
			// Read books
			Iterable<Book> books = bookRepository.findAll();
			books.forEach(System.out::println);

			// Read magazines
			Iterable<Magazine> magazines = magazineRepository.findAll();
			magazines.forEach(System.out::println);

			// Read discMags
			Iterable<DiscMag> discMags = discMagRepository.findAll();
			discMags.forEach(System.out::println);

			// Read tickets
			Iterable<Ticket> tickets = ticketRepository.findAll();
			tickets.forEach(System.out::println);

		}catch (Exception e) {
			throw new Exception("Error reading entities", e);
		}

		// UPDATE entities in the database

		try {
			// Update a book
			Book book = bookRepository.findById(1);
			System.out.println("Before update: " + book);

			book.setAuthor("New Author");
			book.setISBN("New ISBN");
			bookRepository.save(book);

			book = bookRepository.findById(1);
			System.out.println("After update: " + book);

		}catch (Exception e) {
			throw new Exception("Error updating entities", e);
		}


		// DELETE entities from the database

		try {
			// Delete a book
			Book book = bookRepository.findById(5);
			System.out.println("Before delete: " + book);
			bookRepository.delete(book);

			book = bookRepository.findById(5);
			System.out.println("After delete: " + book);

		}catch (Exception e) {
			throw new Exception("Error deleting entities", e);
		}

	}

}
