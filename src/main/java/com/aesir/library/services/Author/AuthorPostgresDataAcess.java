package com.aesir.library.services.Author;

import com.aesir.library.models.Author;
import com.aesir.library.models.Book;
import com.aesir.library.repository.JPARepository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("postgres_authors")
@AllArgsConstructor
public class AuthorPostgresDataAcess implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author getAuthorByName(String name) {
        Optional<Author> author = authorRepository.findAuthorByName(name);
        if(author.isEmpty()) throw new IllegalStateException("No Author Found!!!");
        return author.get();
    }

    @Override
    public List<Book> getBooksByAuthorId(Long Id) {
        Optional<Author>author = authorRepository.findById(Id);
        if(author.isEmpty()) throw new IllegalStateException("No Author By this Id found");
        return author.get().getWrittenBooks();
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
