package com.example.book_spring.controllers;

import com.example.book_spring.entities.Book;
import com.example.book_spring.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
        Optional<Book> currentBook = bookService.update(id);

        if (currentBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book updatedBook = currentBook.get();
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setPrice(book.getPrice());

        return new ResponseEntity<>(bookService.save(updatedBook), HttpStatus.OK);
    }
}
