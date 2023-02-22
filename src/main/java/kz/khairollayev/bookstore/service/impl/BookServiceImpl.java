package kz.khairollayev.bookstore.service.impl;

import kz.khairollayev.bookstore.controller.dto.BookCreateDto;
import kz.khairollayev.bookstore.model.Book;
import kz.khairollayev.bookstore.repository.BookRepository;
import kz.khairollayev.bookstore.service.BookService;
import kz.khairollayev.bookstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book createBook(BookCreateDto createDto) {
        Book book = new Book();
        book.setName(createDto.getName());
        book.setAuthor(createDto.getAuthor());
        book.setCategory(categoryService.getById(createDto.getCategoryId()));
        book.setPrice(createDto.getPrice());
        book.setQuantity(createDto.getQuantity());

        return bookRepository.save(book);
    }
}
