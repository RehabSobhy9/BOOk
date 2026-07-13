package com.example.book_spring.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookAddDto(
        @NotBlank(message = "title is required")
        String title,

        @NotNull(message = "isbn is required")
        Integer isbn,

        @NotNull(message = "price is required")
        @Positive(message = "price should be positive value")
        Double price,

        @NotNull(message = "author id required")
        Long authorId
) {
}
