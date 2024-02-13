package com.taxah.springdz8_storehouse;

import com.taxah.springdz8_storehouse.model.Product;
import com.taxah.springdz8_storehouse.repository.ProductRepository;
import com.taxah.springdz8_storehouse.service.ProductReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for the Reserve module.
 */
@SpringBootTest
class ReserveIntegrationTest {
    @MockBean
    private ProductRepository repository;

    @Autowired
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
