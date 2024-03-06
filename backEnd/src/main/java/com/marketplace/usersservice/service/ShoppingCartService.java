package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.AddProductDTO;
import com.marketplace.usersservice.dto.DeleteProductCartDTO;
import com.marketplace.usersservice.model.Product;
import com.marketplace.usersservice.model.ProductCart;
import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.repository.ProductRepository;
import com.marketplace.usersservice.repository.ShoppingCartRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService implements IShoppingCartService{

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findByUserId(User user) {
        return shoppingCartRepository.findByUserId(user);
    }

    @Override
    @Transactional
    public ShoppingCart addProductCart(AddProductDTO addProductDTO){
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findByUserId(addProductDTO.getUserId());
        //Busco el carrito ya creado sino creo uno nuevo
        if(shoppingCart.isPresent()){
            ShoppingCart cart = shoppingCart.get();
            ProductCart productCart = new ProductCart();
            Product product = productRepository.findById(addProductDTO.getProductId()).get();
            productCart.setProduct(product);
            productCart.setQuantity(addProductDTO.getQuantity());
            productCart.setTotal(product.getPrice() * addProductDTO.getQuantity());
            cart.getProductCart().add(productCart);
            return shoppingCartRepository.save(cart);
        }else{
            ProductCart productCart = new ProductCart();
            Product product = productRepository.findById(addProductDTO.getProductId()).get();
            productCart.setProduct(product);
            productCart.setQuantity(addProductDTO.getQuantity());
            productCart.setTotal(product.getPrice() * addProductDTO.getQuantity());
            List<ProductCart> ListProductCarts = new LinkedList<>();
            ListProductCarts.add(productCart);
            //Seteo el carrito desde cero
            ShoppingCart cart = new ShoppingCart();
            cart.setProductCart(ListProductCarts);
            cart.setUser(new User(addProductDTO.getUserId()));
            cart.setDate(new java.util.Date());
            //Seteo el total del carrito
            Double total = 0.0;
            for(ProductCart pc : cart.getProductCart()){
                total += pc.getTotal();
            }
            cart.setTotal(total);
            return shoppingCartRepository.save(cart);
        }
    
    }

    @Override
    @Transactional
    public ShoppingCart deleteProduct(DeleteProductCartDTO deleteProductDTO){
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findByUserId(deleteProductDTO.getUserId());
        if(shoppingCart.isPresent()){
            ShoppingCart cart = shoppingCart.get();
            cart.getProductCart().removeIf(productCart -> productCart.getId().equals(deleteProductDTO.getProductCartId()));
            return shoppingCartRepository.save(cart);
        }else{
            throw new RuntimeException("Shopping cart not found");
        }
        
        
    }

    @Override
    @Transactional
    public ShoppingCart findById(Long userId) {
        ShoppingCart cart = shoppingCartRepository.findById(userId).orElseThrow(() -> new RuntimeException("Shopping cart not found"));
        return cart;
    }


}
