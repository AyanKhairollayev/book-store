package kz.khairollayev.bookstore.controller;

import kz.khairollayev.bookstore.controller.dto.CategoryCreateDto;
import kz.khairollayev.bookstore.model.Category;
import kz.khairollayev.bookstore.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/api/categories")
    public ResponseEntity<?> create(@RequestBody CategoryCreateDto createDto) {
        String name = categoryService.create(createDto).getName();
        return ResponseEntity.ok().body("Category created - " + name);
    }

    @GetMapping("/api/categories/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
}
