package com.marketplace.usersservice.service;

import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService implements IShoppingCartService{

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findByUserId(User user) {
        return shoppingCartRepository.findByUserId(user);
    }
}
