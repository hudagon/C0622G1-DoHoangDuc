package com.example.labook_be.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_price")
    private int firstPrice;

    @Column(name = "second_price")
    private int secondPrice;

    @Column(name = "description")
    private String description;

}
