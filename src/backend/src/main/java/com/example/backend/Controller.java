package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class Controller {

    @Autowired
    private AddBook addBook;
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        addBook.save(book);
        return "Book added successfully!";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/search")
    public List<Book> queryBook(@RequestParam String title) {
        List<Book> books = addBook.query(title);
        return books;
    }
}
