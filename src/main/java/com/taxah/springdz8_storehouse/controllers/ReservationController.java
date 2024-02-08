package com.taxah.springdz8_storehouse.controllers;

import com.taxah.springdz8_storehouse.aspects.TrackUserAction;
import com.taxah.springdz8_storehouse.model.Product;
import com.taxah.springdz8_storehouse.service.ProductReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The ReservationController class provides endpoints to manage product reservations.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class ReservationController {
    private ProductReservationService service;

    /**
     * Retrieves all products.
     *
     * @return A ResponseEntity containing a list of products.
     */
    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    /**
     * Reserves a product by its ID.
     *
     * @param id The ID of the product to be reserved.
     * @return A ResponseEntity indicating the result of the reservation.
     */
    @TrackUserAction
    @PutMapping("/reserve/{id}")
    public ResponseEntity<String> reserve(@PathVariable Long id) {
        Optional<Product> optional = service.findById(id);
        if (optional.isPresent()) {
            if (!optional.get().isStatus()) {
                service.reserve(optional.get());
                return new ResponseEntity<>("Product reserved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product already reserved", HttpStatus.BAD_REQUEST);
            }
        } else return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to be retrieved.
     * @return The product corresponding to the ID.
     */
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        Optional<Product> optional = service.getProduct(id);
        return optional.orElse(null);
    }
}
