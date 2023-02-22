package kz.khairollayev.bookstore.repository;

import kz.khairollayev.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}