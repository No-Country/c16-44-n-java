package com.marketplace.usersservice.dto;

import com.marketplace.usersservice.model.Image;
import com.marketplace.usersservice.model.ProductCategory;
import com.marketplace.usersservice.model.User;
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
    private String description;
    private String brand;
    private ProductCategory Category;
    private Image image;
    private User user;

}
