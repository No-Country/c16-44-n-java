package com.marketplace.usersservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private int stock;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory Category;
    @Column(name = "user_id")
    private Long userId;
}
