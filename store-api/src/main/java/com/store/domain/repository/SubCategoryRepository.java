package com.store.domain.repository;

import com.store.domain.model.SubCategory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends CustomJpaRepository<SubCategory, Long> {
    boolean existsByNameLikeIgnoreCase(@NonNull String name);
}
