package com.store.domain.service;

import com.store.domain.exception.CategoryExistsException;
import com.store.domain.exception.CategoryNotFoundException;
import com.store.domain.exception.EntityInUseException;
import com.store.domain.model.Category;
import com.store.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CategoryService {

    private static final String MSG_CATEGORY_IN_USE =
            "Category with id %d cannot be deleted because it's in use";
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category save(Category category) throws CategoryExistsException {
        if (categoryRepository.existsByNameLikeIgnoreCase(category.getName()))
            throw new CategoryExistsException(category.getName());

        return categoryRepository.save(category);
    }

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
    }

    @Transactional
    public void delete(Long categoryId) {
        try {
            Category category = getCategory(categoryId);
            categoryRepository.delete(category);
            categoryRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(MSG_CATEGORY_IN_USE, categoryId));
        }

    }
}
