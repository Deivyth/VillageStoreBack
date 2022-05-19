package com.villagestore.api.category.infrastructure;

import com.villagestore.api.category.application.CategoryDto;
import com.villagestore.api.category.application.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories", produces = "application/json")
    ResponseEntity<List<CategoryDto>> getCategories(@RequestParam(name = "partialName", required = false) String partialName) {
        List<CategoryDto> categories;

        if(partialName == null) {
            categories = categoryService.getCategories();
        } else {
            categories = categoryService.getAllCategoriesByName(partialName);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CategoryDto> addCategory (@RequestBody CategoryDto categoryDto) {
        categoryDto = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }
}
