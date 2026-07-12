package com.example.book_spring.services;

import com.example.book_spring.entities.Book;
import com.example.book_spring.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

}
