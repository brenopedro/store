package com.store.domain.service;

import com.store.domain.exception.EntityInUseException;
import com.store.domain.exception.SubCategoryExistsException;
import com.store.domain.exception.SubCategoryNotFoundException;
import com.store.domain.model.SubCategory;
import com.store.domain.repository.SubCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SubCategoryService {

    private static final String MSG_CATEGORY_IN_USE =
            "Sub Category with id %d cannot be deleted because it's in use";
    private final SubCategoryRepository subCategoryRepository;

    @Transactional
    public SubCategory save(SubCategory subCategory) throws SubCategoryExistsException {
        if (subCategoryRepository.existsByNameLikeIgnoreCase(subCategory.getName()))
            throw new SubCategoryExistsException(subCategory.getName());

        return subCategoryRepository.save(subCategory);
    }

    public SubCategory getSubCategory(Long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId).orElseThrow(() -> new SubCategoryNotFoundException(subCategoryId));
    }

    @Transactional
    public void delete(Long subCategoryId) {
        try {
            SubCategory subCategory = getSubCategory(subCategoryId);
            subCategoryRepository.delete(subCategory);
            subCategoryRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(MSG_CATEGORY_IN_USE, subCategoryId));
        }

    }
}
