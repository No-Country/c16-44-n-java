package com.marketplace.usersservice.dto;

import com.marketplace.usersservice.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private Double price;
    private int stock;
    private String brand;
    private ProductCategory Category;
    private Long userId;


}
