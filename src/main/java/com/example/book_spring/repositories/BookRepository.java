package com.example.book_spring.repositories;

import com.example.book_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
