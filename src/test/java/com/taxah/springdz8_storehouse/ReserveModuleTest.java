package com.taxah.springdz8_storehouse;

import com.taxah.springdz8_storehouse.model.Product;
import com.taxah.springdz8_storehouse.repository.ProductRepository;
import com.taxah.springdz8_storehouse.service.ProductReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for the Reserve module.
 */
@ExtendWith(MockitoExtension.class)
class ReserveModuleTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductReservationService service;

    private Product product;

    /**
     * Setup method to initialize the product before each test.
     */
    @BeforeEach
    void setup() {
        product = new Product();
        product.setId(1L);
        product.setName("Notebook");
        product.setCost(2000.0);
    }

    /**
     * Test method for positive product reservation.
     */
    @Test
    void reservePositiveTest() {
        product.setStatus(false);

        service.reserve(product);

        verify(repository).save(product);
    }

    /**
     * Test method for not reserving already reserved product.
     */
    @Test
    void reserveNothingTest() {
        product.setStatus(true);

        service.reserve(product);

        verify(repository, never()).save(product);
    }
}
