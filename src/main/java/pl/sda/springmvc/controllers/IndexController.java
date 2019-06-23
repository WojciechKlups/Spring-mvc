package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springmvc.model.Book;
import pl.sda.springmvc.repositories.BookRepository;

import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    private BookRepository bookRepository;

    public IndexController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("book", new Book());
        return "home";
    }
    @PostMapping("/bookadd")
    public String addBook(@ModelAttribute Book book, Model model){
        bookRepository.save(book);
        model.addAttribute("message", "Book " + book + " added!");
        return "home";
    }
    @GetMapping("/loop")
    public String getBooks(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "loop";
    }

    @GetMapping("/if")
    public String ifExample(Model model){
        model.addAttribute("text", "Sample text");
        model.addAttribute("a", 123);
        model.addAttribute("b", 456);
        return "if";
    }
}
