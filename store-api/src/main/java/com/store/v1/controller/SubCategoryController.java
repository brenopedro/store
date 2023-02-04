package com.store.v1.controller;

import com.store.domain.model.SubCategory;
import com.store.domain.repository.SubCategoryRepository;
import com.store.domain.service.SubCategoryService;
import com.store.v1.assembler.SubCategoryAssembler;
import com.store.v1.assembler.SubCategoryDisassembler;
import com.store.v1.model.SubCategoryModel;
import com.store.v1.model.input.SubCategoryInput;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/sub-categories")
@AllArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryDisassembler subCategoryDisassembler;
    private final SubCategoryAssembler subCategoryAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<SubCategoryModel>> getSubCategoryList() {
        return ResponseEntity.ok(subCategoryAssembler.toCollectionModel(subCategoryRepository.findAll()));
    }

    @GetMapping("/{subCategoryId}")
    public ResponseEntity<SubCategoryModel> getSingleSubCategory(@PathVariable Long subCategoryId) {
        return ResponseEntity.ok(subCategoryAssembler.toModel(subCategoryService.getSubCategory(subCategoryId)));
    }

    @PostMapping
    public ResponseEntity<SubCategoryModel> postSubCategory(@RequestBody SubCategoryInput subCategoryInput) {
        SubCategory categorySaved = subCategoryService.save(subCategoryDisassembler.toDomainObject(subCategoryInput));

        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryAssembler.toModel(categorySaved));
    }

    @DeleteMapping("/{subCategoryId}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long subCategoryId) {
        subCategoryService.delete(subCategoryId);
        return ResponseEntity.noContent().build();
    }
}
