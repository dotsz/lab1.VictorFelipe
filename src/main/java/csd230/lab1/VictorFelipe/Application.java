package csd230.lab1.VictorFelipe;



import csd230.lab1.VictorFelipe.entities.*;
import csd230.lab1.VictorFelipe.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;


	public Application(CartRepository cartRepository, CartItemRepository cartItemRepository) {
		this.cartRepository = cartRepository;
		this.cartItemRepository = cartItemRepository;
	}


	public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		// CREATE entities and save them to the database
		try {
			// Create books
			for (int i = 0; i < 10; i++) {
				Book book = ObjectFactory.createBook();
				cartItemRepository.save(book);
			}

			// Create magazines
			for (int i = 0; i < 10; i++) {
				Magazine magazine = ObjectFactory.createMagazine();
				cartItemRepository.save(magazine);
			}

			// Create discMags
			for (int i = 0; i < 10; i++) {
				DiscMag discMag = ObjectFactory.createDiscMag();
				cartItemRepository.save(discMag);
			}

			// Create tickets
			for (int i = 0; i < 10; i++) {
				Ticket ticket = ObjectFactory.createTicket();
				cartItemRepository.save(ticket);
			}
			Cart cart = new Cart();

			cartRepository.save(cart);


			// Read books only
			cartItemRepository.findByClass(Book.class).forEach(System.out::println);
			// Read magazines only
			cartItemRepository.findByClass(Magazine.class).forEach(System.out::println);

			// update a book
			Book book = (Book) cartItemRepository.findByClass(Book.class).get(0);
			System.out.println("Before update: " + book); // should print the book before updating
			book.setAuthor("New Author");
			cartItemRepository.save(book);
			System.out.println("After update: " + cartItemRepository.findById(book.getId())); // should print the updated book

			// delete a book

			book = (Book) cartItemRepository.findByClass(Book.class).get(0);
			System.out.println("Before delete: " + book); // should print the book before deleting
			cartItemRepository.delete(book);
			System.out.println("After delete: " + cartItemRepository.findById(book.getId())); // should print null


		} catch (Exception e) {
			throw new Exception("Error creating entities", e);
		}




	}

}
