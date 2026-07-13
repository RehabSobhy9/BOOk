package com.example.book_spring.controllers;


import com.example.book_spring.dtos.*;
import com.example.book_spring.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.findAll();
    }

    @PostMapping
    public AuthorResponseDto addAuthor(@RequestBody @Valid AuthorDto author) {
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable Long id, @RequestBody AuthorUpdateDto author) {
        return new ResponseEntity<>(authorService.update(id, author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
