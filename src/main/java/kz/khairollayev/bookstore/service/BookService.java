package kz.khairollayev.bookstore.service;

import kz.khairollayev.bookstore.controller.dto.BookCreateDto;
import kz.khairollayev.bookstore.model.Book;

public interface BookService {
    Book getById(Long id) throws Exception;
    Book createBook(BookCreateDto createDto);
}
