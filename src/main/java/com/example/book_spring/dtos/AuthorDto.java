package com.example.book_spring.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthorDto(
        @NotBlank(message = "firstname is required")
        String firstName,
        @NotBlank(message = "lastname is required")
        String lastName,
        @NotBlank(message = "biography is required")
        String biography
) {
}
