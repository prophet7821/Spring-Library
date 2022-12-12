package com.aesir.library.controllers;

import com.aesir.library.models.Author;
import com.aesir.library.models.Book;
import com.aesir.library.services.Author.AuthorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(@Qualifier("postgres_authors") AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @GetMapping("/books-{authorId}")
    public List<Book> getBooksbyAuthorId(@PathVariable Long authorId){
        return authorService.getBooksByAuthorId(authorId);
    }

    @GetMapping("/{authorName}")
    public Author getAuthorByName(@PathVariable String authorName){
        return authorService.getAuthorByName(authorName);
    }


    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthorById(authorId);
    }
}
