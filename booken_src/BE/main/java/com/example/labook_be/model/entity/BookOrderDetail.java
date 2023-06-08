package com.example.labook_be.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
public class BookOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "book_order_id", referencedColumnName = "id")
    private BookOrder bookOrder;

    @Column(name = "delete_status", columnDefinition = "boolean default false")
    private boolean deleteStatus;

    public BookOrderDetail() {
    }

    public BookOrderDetail(Long id, int quantity, Book book, BookOrder bookOrder, boolean deleteStatus) {
        this.id = id;
        this.quantity = quantity;
        this.book = book;
        this.bookOrder = bookOrder;
        this.deleteStatus = deleteStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookOrder getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}

