package com.store.domain.repository;

import com.store.domain.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CustomJpaRepository<Product, Long>,
        JpaSpecificationExecutor<Product> {
}
