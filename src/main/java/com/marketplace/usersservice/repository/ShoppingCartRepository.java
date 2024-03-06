package com.marketplace.usersservice.repository;

import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByUserId(User user);
    Optional<ShoppingCart> findByUserId(Long user);
}
