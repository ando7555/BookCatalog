package com.library.domain.repository;


import com.library.domain.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends ElasticsearchRepository<Book, String> {
}
