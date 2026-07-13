package com.example.book_spring.services;

import com.example.book_spring.dtos.*;
import com.example.book_spring.entities.Author;
import com.example.book_spring.entities.Book;
import com.example.book_spring.globalhandler.ResourceNotFoundException;
import com.example.book_spring.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponseDto save(AuthorDto author) {

        Author newAuthor = new Author();
        newAuthor.setFirstName(author.firstName());
        newAuthor.setLastName(author.lastName());
        newAuthor.setBiography(author.biography());

        authorRepository.save(newAuthor);
        return new AuthorResponseDto(
                newAuthor.getId(),
                newAuthor.getFirstName(),
                newAuthor.getLastName(),
                newAuthor.getBiography()
        );

    }

    public List<AuthorResponseDto> findAll() {
        return authorRepository.findAll().stream().map(
                author -> new AuthorResponseDto(
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBiography()
                )
        ).toList();
    }

    public AuthorResponseDto update(Long id, AuthorUpdateDto author) {
        Author currentAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());


        currentAuthor.setBiography(author.biography());
        authorRepository.save(currentAuthor);

        return new AuthorResponseDto(
                currentAuthor.getId(),
                currentAuthor.getFirstName(),
                currentAuthor.getLastName(),
                currentAuthor.getBiography()
        );
    }

    public void delete(Long id) {
        Author currentAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        authorRepository.deleteById(id);
    }
}
