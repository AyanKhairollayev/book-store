package kz.khairollayev.bookstore.controller;

import kz.khairollayev.bookstore.controller.dto.BookCreateDto;
import kz.khairollayev.bookstore.model.Book;
import kz.khairollayev.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/api/books/{id}")
    public Book getById(@PathVariable Long id) throws Exception {
        return bookService.getById(id);
    }

    @PostMapping("/api/books")
    public ResponseEntity<?> createBook(@RequestBody BookCreateDto createDto) {
        String name = bookService
                .createBook(createDto).getName();

        return ResponseEntity.ok().body("Book saved - " + name);
    }
}
