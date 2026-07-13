package com.example.book_spring.dtos;

import com.example.book_spring.entities.Author;

public record BookResponseDto(
        Integer id,
        String title,
        Integer isbn,
        Double price,
        Author author

) {
}
