package kz.khairollayev.bookstore.repository;

import kz.khairollayev.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
