package com.store.v1.controller;

import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import com.store.domain.service.ProductService;
import com.store.v1.assembler.ProductAssembler;
import com.store.v1.assembler.ProductDisassembler;
import com.store.v1.model.ProductModel;
import com.store.v1.model.input.ProductInput;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductAssembler productAssembler;
    private final ProductDisassembler productDisassembler;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<CollectionModel<ProductModel>> getProductList() {
        return ResponseEntity.ok(productAssembler.toCollectionModel(productRepository.findAll()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productAssembler.toModel(productService.getProduct(productId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel postProduct(@RequestBody @Valid ProductInput productInput) {
        Product productSaved = productService.save(
                productDisassembler.toDomainObject(productInput));

        return productAssembler.toModel(productSaved);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long departmentId) {
        productService.delete(departmentId);
    }
}
