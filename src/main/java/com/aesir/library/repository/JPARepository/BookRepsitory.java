package com.aesir.library.repository.JPARepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aesir.library.models.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepsitory extends JpaRepository<Book,Long> {
}
