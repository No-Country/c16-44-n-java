package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.service.IShoppingCartService;
import com.marketplace.usersservice.service.ShoppingCartService;
import com.marketplace.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/shoppingcarts")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;



    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCarts() {
        List<ShoppingCart> shoppingCarts = shoppingCartService.findAll();
        return ResponseEntity.ok().body(shoppingCarts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.findById(id);
        return shoppingCart.map(cart -> ResponseEntity.ok().body(cart))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart createdCart = shoppingCartService.save(shoppingCart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ShoppingCart>> getShoppingCartsByUserId(@PathVariable Long userId) {

        Optional<User> userOptional = Optional.ofNullable(userService.findById(userId));


        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // Obtener el usuario de la opción (ya que el usuario es un optional)
        User user = userOptional.get();

        // Llamar al servicio de carrito de compras para encontrar los carritos asociados al usuario
        List<ShoppingCart> shoppingCarts = shoppingCartService.findByUserId(user);

        // Devolver la respuesta con los carritos de compras asociados al usuario
        return ResponseEntity.ok().body(shoppingCarts);
    }
}