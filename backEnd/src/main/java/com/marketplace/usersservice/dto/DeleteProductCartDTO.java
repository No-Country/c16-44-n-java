package com.marketplace.usersservice.dto;

import lombok.Data;

@Data
public class DeleteProductCartDTO {
    private Long productCartId;
    private Long userId;

}
