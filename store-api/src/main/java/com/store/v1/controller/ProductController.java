package com.store.v1.controller;

import com.store.domain.filter.ProductFilter;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import com.store.domain.service.ProductService;
import com.store.infrastructure.repository.spec.ProdutoSpecs;
import com.store.v1.assembler.ProductAssembler;
import com.store.v1.assembler.ProductDisassembler;
import com.store.v1.model.ProductModel;
import com.store.v1.model.input.ProductInput;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
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
    private final PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping
    public PagedModel<ProductModel> getProductList(ProductFilter productFilter, @PageableDefault Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(ProdutoSpecs.filter(productFilter), pageable);


        return pagedResourcesAssembler.toModel(productPage, productAssembler);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productAssembler.toModel(productService.getProduct(productId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel postProduct(@RequestBody @Valid ProductInput productInput) {
        Product productSaved = productService.save(productDisassembler.toDomainObject(productInput));

        return productAssembler.toModel(productSaved);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel putProduct(@PathVariable Long productId, @RequestBody @Valid ProductInput productInput) {
        Product currentProduct = productService.getProduct(productId);
        productDisassembler.copyToDomainObject(productInput, currentProduct);

        return productAssembler.toModel(productService.save(currentProduct));
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long departmentId) {
        productService.delete(departmentId);
    }
}
