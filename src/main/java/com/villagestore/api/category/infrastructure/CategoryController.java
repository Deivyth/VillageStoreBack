package com.villagestore.api.category.infrastructure;

import com.villagestore.api.category.application.CategoryDto;
import com.villagestore.api.category.application.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories/{categoryId}", produces = "application/json")
    public ResponseEntity<CategoryDto> getCategoryById (@PathVariable Long categoryId) {
        return categoryService
                .getCategoryById(categoryId)
                .map(categoryDto -> new ResponseEntity(categoryDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CategoryDto> addCategory (@RequestBody CategoryDto categoryDto) {
        categoryDto = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }
}
