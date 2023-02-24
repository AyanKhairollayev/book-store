package kz.khairollayev.bookstore.service;

import kz.khairollayev.bookstore.controller.dto.BookCreateDto;
import kz.khairollayev.bookstore.model.Book;
import kz.khairollayev.bookstore.model.Category;
import kz.khairollayev.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
@DisplayName("Должен ")
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private BookRepository bookRepository;

    @Test
    @DisplayName("корректно возвращать книгу")
    void createBookTest() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Classic");

        BookCreateDto createDto = new BookCreateDto();
        createDto.setName("Alchemist");
        createDto.setAuthor("Paulo Coelho");
        createDto.setPrice(3.55);
        createDto.setQuantity(700);
        createDto.setCategoryId(category.getId());

        Book book = new Book();
        book.setCategory(category);
        book.setQuantity(700);
        book.setAuthor("Paulo Coelho");
        book.setName("Alchemist");
        book.setId(1L);

        Mockito.when(categoryService.getById(2L)).thenReturn(category);
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

        var res = bookService.createBook(createDto);

        Assertions.assertEquals(res.getName(), "Alchemist");
        Assertions.assertEquals(res.getAuthor(), "Paulo Coelho");
        Assertions.assertEquals(res.getCategory().getName(), "Classic");
        Assertions.assertEquals(res.getQuantity(), 700);
    }
}
