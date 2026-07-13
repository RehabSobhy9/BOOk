package com.example.book_spring.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthorResponseDto(
        Long id,
        String firstName,
        String lastName,
        String biography) {
}
