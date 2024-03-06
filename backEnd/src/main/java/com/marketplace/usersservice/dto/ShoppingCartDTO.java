package com.marketplace.usersservice.dto;

import com.marketplace.usersservice.model.ProductCart;
import com.marketplace.usersservice.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartDTO {

    private Long id;
    private Date date;
    private Double total;
    private User user;
    private List<ProductCart> productCart;
}
