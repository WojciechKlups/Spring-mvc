package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.springmvc.model.Book;

import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("book", new Book());
        return "home";
    }
    @PostMapping("/bookadd")
    public String addBook(@ModelAttribute Book book, Model model){

        model.addAttribute("message", "Book " + book + " added!");
        return "home";
    }
    @GetMapping("/loop")
    public String getBooks(Model model){
        List<Book> books = Arrays.asList(
                new Book("Jan Kowalski", "No lol", 56.00),
                new Book("Jan Nowak", "HaHahA", 45.00),
                new Book("Jan Paweł", "Drugi", 67.00),
                new Book("Jan Tentego", "Tenteges", 34.00),
                new Book("Jan Bizon", "Żubr wczoraj i dziś", 35.00),
                new Book("Jan Gaweł", "Gęgę", 69.00)
        );
        model.addAttribute("books", books);
        return "loop";
    }
}
