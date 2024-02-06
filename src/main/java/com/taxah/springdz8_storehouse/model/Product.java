package com.taxah.springdz8_storehouse.model;


import jakarta.persistence.*;
import lombok.Data;

/**
 * The Product class represents a product entity.
 */
@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cost", nullable = false)
    private Double cost;
    @Column(name = "status")
    private boolean status = false;
}
