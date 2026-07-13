package com.example.book_spring.services;

import com.example.book_spring.dtos.BookAddDto;
import com.example.book_spring.dtos.BookResponseDto;
import com.example.book_spring.dtos.BookUpdateDto;
import com.example.book_spring.entities.Book;
import com.example.book_spring.globalhandler.ResourceNotFoundException;
import com.example.book_spring.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponseDto save(BookAddDto book) {
        Book newBook = new Book();

        newBook.setTitle(book.title());
        newBook.setAuthor(book.author());
        newBook.setIsbn(book.isbn());
        newBook.setPrice(book.price());

        Book savedBook = bookRepository.save(newBook);
        return new BookResponseDto(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor(),
                savedBook.getIsbn(),
                savedBook.getPrice()
        );
    }

    public List<BookResponseDto> findAll() {

        return bookRepository.findAll().stream()
                .map(
                        book -> new BookResponseDto(
                                book.getId(),
                                book.getTitle(),
                                book.getAuthor(),
                                book.getIsbn(),
                                book.getPrice())
                ).toList();
    }


    public BookResponseDto update(int id, BookUpdateDto book) {
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());


        currentBook.setPrice(book.price());
        bookRepository.save(currentBook);

        return new BookResponseDto(
                currentBook.getId(),
                currentBook.getTitle(),
                currentBook.getAuthor(),
                currentBook.getIsbn(),
                currentBook.getPrice()
        );
    }

    public void delete(int id) {
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException()
                );

        bookRepository.deleteById(id);
    }

    public BookResponseDto findByIsbn(int isbn) {
        Book currentBook = bookRepository.findByIsbn(isbn).orElseThrow(
                () -> new ResourceNotFoundException()
        );

        return new BookResponseDto(
                currentBook.getId(),
                currentBook.getTitle(),
                currentBook.getAuthor(),
                currentBook.getIsbn(),
                currentBook.getPrice()
        );
    }
}
