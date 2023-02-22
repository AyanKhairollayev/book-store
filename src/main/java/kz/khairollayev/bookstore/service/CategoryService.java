package kz.khairollayev.bookstore.service;

import kz.khairollayev.bookstore.controller.dto.CategoryCreateDto;
import kz.khairollayev.bookstore.model.Category;

public interface CategoryService {
    Category create(CategoryCreateDto createDto);
    Category getById(Long id);
}
