package com.store.domain.service;

import com.store.domain.exception.ProductNotFoundException;
import com.store.domain.model.Department;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final DepartmentService departmentService;
    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        Long departmentId = product.getDepartment().getId();
        Department department = departmentService.getDepartment(departmentId);

        product.setDepartment(department);
        return productRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Transactional
    public void delete(Long productId) {
        Product product = getProduct(productId);
        productRepository.delete(product);
    }

    @Transactional
    public void activate(Long productId) {
        Product product = getProduct(productId);

        product.activate();
    }

    @Transactional
    public void deactivate(Long productId) {
        Product product = getProduct(productId);

        product.deactivate();
    }

    @Transactional
    public void activateMultiples(List<Long> productsId) {
        productsId.forEach(this::activate);
    }

    @Transactional
    public void deactivateMultiples(List<Long> productsId) {
        productsId.forEach(this::deactivate);
    }

    @Transactional
    public Product changePrice(Long productId, BigDecimal newPrice) {
        Product product = getProduct(productId);
        product.changePrice(newPrice);

        return product;
    }

    @Transactional
    public Product changeInventory(Long productId, Integer newInventory) {
        Product product = getProduct(productId);
        product.chageInventory(newInventory);

        return product;
    }
}
