package com.library.domain.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Set;

@Document(indexName = "catalog", type = "books")
public class Book {

    @Id
    @Field(name = "isbn", type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    private String title;

    @Field(type = FieldType.Nested)
    private Set<Categories> categories;

    @Field(type = FieldType.Keyword)
    private String publisher;

    @Field(name = "publish_date", type = FieldType.Date)
    private Date publishDate;

    @Field(type = FieldType.Byte)
    private byte rate;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title, String publisher, Date publishDate, byte rate) {
        this.title = title;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.rate = rate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public byte getRate() {
        return rate;
    }

    public void setRate(byte rate) {
        this.rate = rate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}


