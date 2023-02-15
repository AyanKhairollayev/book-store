package kz.khairollayev.bookstore.service;

import kz.khairollayev.bookstore.model.Book;

public interface BookService {
    Book getById(Long id) throws Exception;
    Long createBook(String name, Integer quantity);
}
