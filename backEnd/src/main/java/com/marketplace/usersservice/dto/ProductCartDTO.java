package com.marketplace.usersservice.dto;

import com.marketplace.usersservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCartDTO {

    private Long id;
    private int quantity;
    private Double price;
    private Double total;
    private Product product;

}
