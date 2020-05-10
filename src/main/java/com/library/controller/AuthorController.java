package com.library.controller;

import com.library.domain.dto.AuthorDto;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("/author/")
    public AuthorDto save(@RequestBody AuthorDto author) {
        return service.save(author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthorById(@PathVariable String id) {
        service.deleteAuthorById(id);
    }

    @PutMapping("/author/{id}")
    public AuthorDto updateAuthor(@PathVariable String id, @RequestBody AuthorDto authorDto) {
        return service.updateBook(id, authorDto);
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable String id){
        return service.getById(id);
    }

    @GetMapping("/authors/")
    public List<AuthorDto> getAllAuthors(){
        return service.getAll();
    }
}
