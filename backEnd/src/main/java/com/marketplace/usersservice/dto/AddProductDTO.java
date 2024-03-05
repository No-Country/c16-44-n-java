package com.marketplace.usersservice.dto;

import lombok.Data;

@Data
public class AddProductDTO {
    private Long productId;
    private Long userId;
    private int quantity;
}
