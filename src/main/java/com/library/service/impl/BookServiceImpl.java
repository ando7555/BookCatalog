package com.library.service.impl;

import com.library.domain.dto.BookDto;
import com.library.domain.entity.Book;
import com.library.domain.repository.BookRepository;
import com.library.exception.BookNotFoundException;
import com.library.mapper.BookMapper;
import com.library.service.BookService;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.join.query.HasChildQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final BookRepository bookRepository;
    private final BookMapper mapper;

    @Autowired
    public BookServiceImpl(ElasticsearchTemplate elasticsearchTemplate, BookRepository bookRepository, BookMapper mapper) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }



    @Override
    public BookDto update(String id, BookDto newBookDto) {
        Book newBook = mapper.toEntity(newBookDto);
        bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setPublishDate(newBook.getPublishDate());
                    book.setRate(newBook.getRate());
                    book.setCategories(newBook.getCategories());
                    book.setPublisher(newBook.getPublisher());
                    book.setAuthors(newBook.getAuthors());
                  return bookRepository.save(book);
                }).orElseThrow(()-> new BookNotFoundException("Book with metioned not found " + id));
         return newBookDto;
    }

    @Override
    public BookDto save(BookDto bookDto) {
        Book book = mapper.toEntity(bookDto);
        bookRepository.save(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getBooksByAuthor(String firstName, String lastName) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(new HasChildQueryBuilder("authors",
                        new BoolQueryBuilder().must(
                                new TermQueryBuilder("first_name",firstName)).
                                must(new TermQueryBuilder("last_name",lastName)), ScoreMode.Total))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, BookDto.class);
    }

    @Override
    public List<BookDto> getBooksByTitle(String title) {
        MatchQueryBuilder searchByTitle = QueryBuilders.matchQuery("title", title);
        return mapper.toDtos(bookRepository.search(searchByTitle));
        }



    @Override
    public BookDto findByIsbn(String isbn) {
        return mapper.toDto(bookRepository.findById(isbn)
               .orElseThrow(() -> new BookNotFoundException(isbn + " with that id nor found")));
    }

    @Override
    public void deleteBookById(String isbn){
        bookRepository.deleteById(isbn);
    }

    @Override
    public List<BookDto> booksSortedByPublishDate(){
        return mapper.toDtos((bookRepository.findAll(Sort.by(Sort.Order.by("publish_date")))));
    }
}
