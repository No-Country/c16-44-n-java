package com.marketplace.usersservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "product_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    //private Double price;
    private Double total;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductCart(Long id){
        this.id = id;
    }
}
