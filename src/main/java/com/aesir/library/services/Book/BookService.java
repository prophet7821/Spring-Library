package com.aesir.library.services.Book;

import com.aesir.library.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBookById(Long bookId);
}
