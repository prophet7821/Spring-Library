package com.aesir.library.services.Book;

import com.aesir.library.models.Author;
import com.aesir.library.models.Book;
import com.aesir.library.repository.JPARepository.AuthorRepository;
import com.aesir.library.repository.JPARepository.BookRepsitory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("postgres_books")
@AllArgsConstructor
public class BookPostgresDataAcess implements BookService{

    private final BookRepsitory bookRepsitory;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepsitory.findAll();
    }

    @Override
    public void addBook(Book book) {
        String name = book.getAuthor().getName();
        Optional<Author> author = authorRepository.findAuthorByName(name);
        Author newAuthor;
        if(author.isEmpty()){
            newAuthor = new Author(name);
            newAuthor=authorRepository.save(newAuthor);
        }else newAuthor = author.get();

        book.setAuthor(newAuthor);
        bookRepsitory.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepsitory.deleteById(bookId);
    }
}
