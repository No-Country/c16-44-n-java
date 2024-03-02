package com.marketplace.usersservice.service;

import com.marketplace.usersservice.model.ProductCart;
import com.marketplace.usersservice.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCartService implements IProductCartService{

    @Autowired
    private ProductCartRepository productCartRepository;
    @Override
    public ProductCart save(ProductCart productCart) {

        return productCartRepository.save(productCart);
    }
}
