package com.example.book_spring.controllers;

import com.example.book_spring.dtos.BookAddDto;
import com.example.book_spring.dtos.BookResponseDto;
import com.example.book_spring.dtos.BookUpdateDto;
import com.example.book_spring.entities.Book;
import com.example.book_spring.services.BookService;
import jakarta.validation.Valid;
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
    public BookResponseDto addBook(@RequestBody @Valid BookAddDto book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable int id, @RequestBody BookUpdateDto book) {
        return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookResponseDto> findByIsbn(@PathVariable int isbn) {
        return new ResponseEntity<>(bookService.findByIsbn(isbn), HttpStatus.OK);
    }
}
