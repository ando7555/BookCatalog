package com.library.service.impl;

import com.library.domain.dto.AuthorDto;
import com.library.domain.entity.Author;
import com.library.domain.repository.AuthorRepository;
import com.library.exception.AuthorNotFoundException;
import com.library.mapper.AuthorMapper;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper mapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
       Author author = mapper.toEntity(authorDto);
       authorRepository.save(author);
        return authorDto;
    }

    @Override
    public void deleteAuthorById(String id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto getById(String id) {
        return mapper.toDto(authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id + " Author not found")));
    }

    @Override
    public AuthorDto updateBook(String id, AuthorDto newAuthorDto) {
        return mapper.toDto(authorRepository.findById(id)
                .map(author -> {
                            author.setFirstName(newAuthorDto.getFirstName());
                            author.setLastName(newAuthorDto.getLastName());
                            return authorRepository.save(author);
                        }

                ).orElseThrow(() -> new AuthorNotFoundException(id + " Author not found")));
    }

    @Override
    public List<AuthorDto> getAll() {
        return mapper.toDtos(authorRepository.findAll());
    }
}