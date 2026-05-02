package com.example.library;

import com.example.library.dto.BookAuthorDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testFindBooksWithAuthors() {
        Author author = new Author("Jane Austen");
        author = authorRepository.save(author);

        Book book = new Book("Pride and Prejudice", "Romance", author);
        bookRepository.save(book);

        List<BookAuthorDTO> result = bookRepository.findBooksWithAuthors();

        assertFalse(result.isEmpty());
        assertEquals("Pride and Prejudice", result.get(0).getTitle());
        assertEquals("Jane Austen", result.get(0).getAuthorName());
    }
}
