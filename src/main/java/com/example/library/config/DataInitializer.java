package com.example.library.config;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            if (authorRepository.count() == 0) {
                List<Author> authors = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    authors.add(new Author("Author " + i));
                }
                authorRepository.saveAll(authors);

                List<Book> books = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    books.add(new Book("Book Title " + i, "Genre " + (i % 3 + 1), authors.get(i - 1)));
                }
                bookRepository.saveAll(books);
            }
        };
    }
}
