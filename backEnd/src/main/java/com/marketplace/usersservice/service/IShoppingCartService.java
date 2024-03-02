package com.marketplace.usersservice.service;

import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;

import java.util.List;
import java.util.Optional;

public interface IShoppingCartService {
    List<ShoppingCart> findAll();
    Optional<ShoppingCart> findById(Long id);
    ShoppingCart save(ShoppingCart shoppingCart);
    List<ShoppingCart> findByUserId(User user);

}
