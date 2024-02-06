package com.taxah.springdz8_storehouse.service;

import com.taxah.springdz8_storehouse.model.Product;
import com.taxah.springdz8_storehouse.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The ProductReservationService class provides methods to manage product reservations.
 */
@AllArgsConstructor
@Service
public class ProductReservationService {
    private ProductRepository repository;

    /**
     * Retrieves all products.
     *
     * @return A list of products.
     */
    public List<Product> getAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return An Optional containing the product, if found.
     */
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Reserves a product.
     *
     * @param product The product to be reserved.
     */
    @Transactional // метод маленький и тут только один вызов метода, поэтому не обязательна аннотация
    public void reserve(Product product) {
        if (!product.isStatus()) {
            product.setStatus(true);
            repository.save(product);
        }
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return An Optional containing the product, if found.
     */
    public Optional<Product> getProduct(Long id) {
        return repository.findById(id);
    }
}
