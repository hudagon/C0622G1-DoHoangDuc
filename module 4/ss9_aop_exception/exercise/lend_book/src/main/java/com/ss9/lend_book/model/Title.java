package com.ss9.lend_book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    private String category;

    private Integer count;


    @OneToMany(mappedBy = "title")
    private Set<Book> books;

    public Title() {
    }

    public Title(Integer id, String name, String author, String category, Integer count, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.count = count;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
