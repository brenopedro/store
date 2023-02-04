package com.store.v1.controller;

import com.store.domain.model.Category;
import com.store.domain.repository.CategoryRepository;
import com.store.domain.service.CategoryService;
import com.store.v1.assembler.CategoryAssembler;
import com.store.v1.assembler.CategoryDisassembler;
import com.store.v1.model.CategoryModel;
import com.store.v1.model.input.CategoryInput;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final CategoryDisassembler categoryDisassembler;
    private final CategoryAssembler categoryAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<CategoryModel>> getCategoryList() {
        return ResponseEntity.ok(categoryAssembler.toCollectionModel(categoryRepository.findAll()));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryModel> getSingleCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryAssembler.toModel(categoryService.getCategory(categoryId)));
    }

    @PostMapping
    public ResponseEntity<CategoryModel> postCategory(@RequestBody CategoryInput categoryInput) {
        Category categorySaved = categoryService.save(categoryDisassembler.toDomainObject(categoryInput));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryAssembler.toModel(categorySaved));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.noContent().build();
    }
}
