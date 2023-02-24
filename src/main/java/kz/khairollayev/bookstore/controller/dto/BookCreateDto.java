package kz.khairollayev.bookstore.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateDto {
    private String name;
    private String author;
    private double price;
    private Long categoryId;
    private Integer quantity;
}
