package kz.khairollayev.bookstore.service;

import kz.khairollayev.bookstore.model.Book;
import kz.khairollayev.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Long createBook(String name, Integer quantity) {
        Book book = new Book();
        book.setName(name);
        book.setQuantity(quantity);

        return bookRepository.save(book).getId();
    }
}
