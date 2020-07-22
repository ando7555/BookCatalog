package com.library.mapper;

import com.library.domain.dto.AuthorDto;
import com.library.domain.dto.BookDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookDto dto);

    BookDto toDto(Book book);

    List<BookDto> toDtos(Iterable<Book> authors);
}
