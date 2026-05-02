package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", libraryService.getBooksWithAuthors());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String genre, @RequestParam Long authorId, Model model) {
        try {
            libraryService.addBook(title, genre, authorId);
            return "redirect:/library";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Data integrity violation: " + e.getMessage());
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "add";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Book book = libraryService.getBookById(id);
        if (book == null) {
            return "redirect:/library";
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @RequestParam String title, @RequestParam String genre, @RequestParam Long authorId, Model model) {
        try {
            libraryService.updateBook(id, title, genre, authorId);
            return "redirect:/library";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Data integrity violation: " + e.getMessage());
            model.addAttribute("book", libraryService.getBookById(id));
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "update";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            model.addAttribute("book", libraryService.getBookById(id));
            model.addAttribute("authors", libraryService.getAllAuthors());
            return "update";
        }
    }
}
