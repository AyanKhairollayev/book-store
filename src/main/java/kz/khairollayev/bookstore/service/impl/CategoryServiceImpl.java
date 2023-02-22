package kz.khairollayev.bookstore.service.impl;

import kz.khairollayev.bookstore.controller.dto.CategoryCreateDto;
import kz.khairollayev.bookstore.model.Category;
import kz.khairollayev.bookstore.repository.CategoryRepository;
import kz.khairollayev.bookstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryCreateDto createDto) {
        Category category = new Category();
        category.setName(createDto.getName());

        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
