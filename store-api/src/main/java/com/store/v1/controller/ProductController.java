package com.store.v1.controller;

import com.store.domain.filter.ProductFilter;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import com.store.domain.service.ProductService;
import com.store.infrastructure.repository.spec.ProductSpecs;
import com.store.v1.assembler.ProductAssembler;
import com.store.v1.assembler.ProductDisassembler;
import com.store.v1.assembler.ProductResumoModelAssembler;
import com.store.v1.model.ProductModel;
import com.store.v1.model.ProductResumoModel;
import com.store.v1.model.input.ProductInput;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductResumoModelAssembler productResumoModelAssembler;
    private final ProductAssembler productAssembler;
    private final ProductDisassembler productDisassembler;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping
    public PagedModel<ProductModel> getProductList(ProductFilter productFilter, @PageableDefault Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(ProductSpecs.filter(productFilter), pageable);


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
    public ResponseEntity<ProductModel> putProduct(@PathVariable Long productId, @RequestBody @Valid ProductInput productInput) {
        Product currentProduct = productService.getProduct(productId);

        return ResponseEntity.ok(productAssembler.toModel(productService.save(currentProduct)));
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long departmentId) {
        productService.delete(departmentId);
    }

    @PutMapping("/{productId}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long productId) {
        productService.activate(productId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{productId}/activate")
    public ResponseEntity<Void> deactivate(@PathVariable Long productId) {
        productService.deactivate(productId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/activations")
    public ResponseEntity<Void> activateMultiples(@RequestBody List<Long> productsId) {
        productService.activateMultiples(productsId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/activations")
    public ResponseEntity<Void> deactivateMultiples(@RequestBody List<Long> productsId) {
        productService.deactivateMultiples(productsId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productId}/new-price")
    public ResponseEntity<ProductResumoModel> changePrice(@PathVariable Long productId, @RequestBody BigDecimal newPrice) {
        Product product = productService.changePrice(productId, newPrice);

        return ResponseEntity.ok(productResumoModelAssembler.toModel(product));
    }

    @PutMapping("/{productId}/new-inventory")
    public ResponseEntity<ProductResumoModel> changeInventory(@PathVariable Long productId, @RequestBody Integer newInventory) {
        Product product = productService.changeInventory(productId, newInventory);

        return ResponseEntity.ok(productResumoModelAssembler.toModel(product));
    }
}
