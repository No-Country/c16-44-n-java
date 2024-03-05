package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.dto.AddProductDTO;
import com.marketplace.usersservice.dto.DeleteProductCartDTO;
import com.marketplace.usersservice.model.ProductCart;
import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.service.IShoppingCartService;
import com.marketplace.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/shoppingcarts")
@CrossOrigin(origins = "*")
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

    // @GetMapping("/{id}")
    // public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id) {
    //     Optional<ShoppingCart> shoppingCart = shoppingCartService.findById(id);
    //     return shoppingCart.map(cart -> ResponseEntity.ok().body(cart))
    //             .orElseGet(() -> ResponseEntity.notFound().build());
    // }

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart createdCart = shoppingCartService.save(shoppingCart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

    //Yo digo que esto sí------------------------------------------------------------

    //Que nos envien que se quiere incluir al carrito de ese usuario
    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody AddProductDTO addProductDTO) {
        ShoppingCart updatedCart = shoppingCartService.addProductCart(addProductDTO);
        return ResponseEntity.ok().body(updatedCart);
    }

    //Que nos envien el id del productCart que se quiere eliminar
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<ShoppingCart> deleteProductFromShoppingCart(@RequestBody DeleteProductCartDTO deleteProductDTO) {
        ShoppingCart updatedCart = shoppingCartService.deleteProduct(deleteProductDTO);
        return ResponseEntity.ok().body(updatedCart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.findById(userId);
        return ResponseEntity.ok().body(shoppingCart);
    }
}