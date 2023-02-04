package com.store.domain.repository;

import com.store.domain.model.Category;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CustomJpaRepository<Category, Long> {
    boolean existsByNameLikeIgnoreCase(@NonNull String name);
}
