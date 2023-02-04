package com.store.domain.repository;

import com.store.domain.model.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CustomJpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book> {
}
