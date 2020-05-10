package com.library.domain.dto;

public class CategoriesDto {

    private String name;

    public CategoriesDto() {
    }

    public CategoriesDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
