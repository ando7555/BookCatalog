package com.library.mapper;

import com.library.domain.dto.AuthorDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorDto dto);

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtos(Iterable<Author> authors);
}
