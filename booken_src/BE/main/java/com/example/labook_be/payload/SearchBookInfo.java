package com.example.labook_be.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBookInfo {

    private String name;
    private int categoryId;
    private int authorId;
    private int priceRangeId;
    private int pageNumber;
    private int pageSize;
    private int sortOption;
    private boolean sortDirection;

}
