package com.example.library.service;

import com.example.library.dto.BookAuthorDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookAuthorDTO> getBooksWithAuthors() {
        return bookRepository.findBooksWithAuthors();
    }

    @Transactional
    public Book addBook(String title, String genre, Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + authorId));
        Book book = new Book(title, genre, author);
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long bookId, String title, String genre, Long authorId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + authorId));

        book.setTitle(title);
        book.setGenre(genre);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
