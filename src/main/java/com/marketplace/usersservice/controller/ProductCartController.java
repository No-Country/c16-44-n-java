package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.model.ProductCart;
import com.marketplace.usersservice.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product-cart")
@CrossOrigin(origins = "*")
public class ProductCartController {

    @Autowired
    private ProductCartRepository productCartRepository;


    @PostMapping("/save")
    public ResponseEntity<ProductCart> saveProductCart(@RequestBody ProductCart productCart) {
        ProductCart savedProductCart = productCartRepository.save(productCart);
        return new ResponseEntity<>(savedProductCart, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCart> getProductCartById(@PathVariable Long id) {
        ProductCart productCart = productCartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductCart not found with id: " + id));
        return new ResponseEntity<>(productCart, HttpStatus.OK);
    }


}
