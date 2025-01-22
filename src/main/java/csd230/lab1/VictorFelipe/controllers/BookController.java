package csd230.lab1.VictorFelipe.controllers;

import csd230.lab1.VictorFelipe.entities.Book;
import csd230.lab1.VictorFelipe.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String getAllBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }


    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/editBook")
    public String edit_book(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Book book = bookRepository.findById(id);
        model.addAttribute("book", book);
        return "editBook";
    }
    @PostMapping("/editBook")
    public String edit_bookSubmit(@ModelAttribute Book book, Model model) {
//        model.addAttribute("book", book);
        book.setDescription("Book: "+book.getTitle());
        bookRepository.save(book);
//        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/books";
    }

    @GetMapping("/editBook/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setISBN(updatedBook.getISBN());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setQuantity(updatedBook.getQuantity());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setCopies(updatedBook.getCopies());
            bookRepository.save(existingBook);
        }
        return "redirect:/books";
    }



    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }



}
