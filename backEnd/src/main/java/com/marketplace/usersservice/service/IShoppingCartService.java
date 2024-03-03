package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.AddProductDTO;
import com.marketplace.usersservice.dto.DeleteProductCartDTO;
import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;

import java.util.List;
import java.util.Optional;

public interface IShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Long userId);
    ShoppingCart save(ShoppingCart shoppingCart);
    List<ShoppingCart> findByUserId(User user);
    ShoppingCart addProductCart(AddProductDTO addProductDTO);
    ShoppingCart deleteProduct(DeleteProductCartDTO deleteProductDTO);
}
