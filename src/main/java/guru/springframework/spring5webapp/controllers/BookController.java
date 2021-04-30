package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repos.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("bookList", bookRepository.findAll());
        return "books/list";
    }
}
