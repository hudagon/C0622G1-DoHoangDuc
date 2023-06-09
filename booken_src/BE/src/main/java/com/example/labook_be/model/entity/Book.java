package com.example.labook_be.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "img_url", length = 500)
    private String imgUrl;

    private int price;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @JsonBackReference
    @OneToMany(mappedBy = "book")
    private Set<BookOrderDetail> bookOrderDetailSet;

    @Column(name = "input_date")
    private Date inputDate;

    @Column(name = "delete_status", columnDefinition = "boolean default false")
    private boolean deleteStatus;

}
