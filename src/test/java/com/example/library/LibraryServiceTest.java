package com.example.library;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Author author = new Author("John Doe");
        author.setId(1L);

        Book book = new Book("Test Book", "Fiction", author);
        book.setId(1L);

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook = libraryService.addBook("Test Book", "Fiction", 1L);

        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
        assertEquals("John Doe", savedBook.getAuthor().getName());
    }
}
