package com.library.service;

import com.library.domain.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto save(BookDto book);

    List<BookDto> getBooksByAuthor(String firstName, String lastName);

    List<BookDto> getBooksByTitle(String title);

    BookDto update(String id, BookDto newBook);

    BookDto findByIsbn(String isbn);

    void deleteBookById(String isbn);

    List<BookDto> booksSortedByPublishDate();
}
