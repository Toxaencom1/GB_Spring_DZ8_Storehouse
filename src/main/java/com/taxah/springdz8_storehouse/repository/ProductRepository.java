package com.taxah.springdz8_storehouse.repository;

import com.taxah.springdz8_storehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The ProductRepository interface provides CRUD operations for managing Product entities.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
