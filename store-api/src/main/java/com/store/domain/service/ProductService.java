package com.store.domain.service;

import com.store.domain.exception.ProductNotFoundException;
import com.store.domain.model.Department;
import com.store.domain.model.Product;
import com.store.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void delete(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
    }
}
