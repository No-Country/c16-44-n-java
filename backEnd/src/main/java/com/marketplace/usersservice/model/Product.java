package com.marketplace.usersservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(max = 30, message = "Name should be less than 30 characters")
    @Column(name= "name", length = 30)
    private String name;
    @NotNull
    private Double price;
    private int stock;
    @Size(max = 150, message = "Description should be less than 150 characters")
    private String description;
    @NotNull
    @Size(max = 30, message = "Brand should be less than 30 characters")
    private String brand;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory Category;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}