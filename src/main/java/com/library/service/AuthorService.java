package com.library.service;

import com.library.domain.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto save(AuthorDto authorDto);

    void deleteAuthorById(String id);

    AuthorDto getById(String id);

    AuthorDto updateBook(String id, AuthorDto newAuthorDto);

    List<AuthorDto> getAll();
}
