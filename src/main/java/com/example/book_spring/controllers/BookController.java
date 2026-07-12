package com.example.book_spring.controllers;

import com.example.book_spring.entities.Book;
import com.example.book_spring.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.findAll();
    }
}
