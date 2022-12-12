package com.aesir.library.services.Author;

import com.aesir.library.models.Author;
import com.aesir.library.models.Book;

import java.util.List;
import java.util.Set;


public interface AuthorService{

    List<Author> getAllAuthors();
    void addAuthor(Author auhtor);

    Author getAuthorByName(String name);

    List<Book> getBooksByAuthorId(Long Id);

    void deleteAuthorById(Long authorId);
}
