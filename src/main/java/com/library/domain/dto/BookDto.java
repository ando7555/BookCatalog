package com.library.domain.dto;



import java.util.Date;
import java.util.Set;

public class BookDto {


    private String id;

    private String title;

    private Set<CategoriesDto> categories;

    private String publisher;

    private Date publishDate;

    private byte rate;

    private Set<AuthorDto> authors;

    public BookDto() {
    }

    public BookDto(String title, Set<CategoriesDto> categories, String publisher, Date publishDate, byte rate, Set<AuthorDto> authors) {
        this.title = title;
        this.categories = categories;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.rate = rate;
        this.authors = authors;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<CategoriesDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesDto> categories) {
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

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }
}
