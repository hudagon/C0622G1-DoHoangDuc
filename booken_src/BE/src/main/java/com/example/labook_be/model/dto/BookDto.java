package com.example.labook_be.model.dto;

import com.example.labook_be.model.entity.Author;
import com.example.labook_be.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;

    private String imgUrl;

    private int price;

    private Category category;

    private Author author;

    private Date inputDate;

    private boolean deleteStatus;

}
