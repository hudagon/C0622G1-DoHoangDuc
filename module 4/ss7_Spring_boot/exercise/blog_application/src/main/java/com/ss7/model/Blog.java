package com.ss7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {

    @Id
    private int id;
    private String name;
    private String author;
    private String datePublished;
    private String content;

    public Blog() {
    }

    public Blog(int id, String name, String author, String datePublished, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.datePublished = datePublished;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
