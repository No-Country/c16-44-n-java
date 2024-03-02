package com.marketplace.usersservice.repository;

import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUserId(User user);
}
