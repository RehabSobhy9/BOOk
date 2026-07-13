package com.example.book_spring.dtos;

public record BookResponseDto(
        Integer id,
        String title,
        String author,
        Integer isbn,
        Double price

) {
}
