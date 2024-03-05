package com.marketplace.usersservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static ProductCategory getDefaultProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        productCategory.setName("Default");
        return productCategory;
    }
}
