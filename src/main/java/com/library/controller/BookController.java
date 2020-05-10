package com.library.controller;

import com.library.domain.dto.BookDto;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/book")
    public BookDto addBook(@RequestBody BookDto book) {
        return bookService.save(book);
    }

    @PutMapping("/book/{id}")
    public BookDto updateBook(@PathVariable String id, @RequestBody BookDto book) {
        return bookService.update(id, book);
    }

    @GetMapping("/books/by/title")
    public List<BookDto> booksByTitle(@RequestParam String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/books/by/author")
    public List<BookDto> booksByAuthor(@RequestParam String firstName, String lastName) {
        return bookService.getBooksByAuthor(firstName, lastName);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/book/{id}")
    public BookDto getBookById(@PathVariable String id) {
        return bookService.findByIsbn(id);
    }

    @GetMapping("/books")
    public List<BookDto> findAllBooksSortedByPublishDate() {
        return bookService.booksSortedByPublishDate();
    }
}
