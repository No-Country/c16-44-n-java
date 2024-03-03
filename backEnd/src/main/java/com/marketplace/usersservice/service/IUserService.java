package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.AddProductDTO;
import com.marketplace.usersservice.dto.UserDTO;
import com.marketplace.usersservice.dto.UserLoginDTO;
import com.marketplace.usersservice.model.ShoppingCart;
import com.marketplace.usersservice.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    User save(UserDTO user);
    User login(UserLoginDTO userLoginDTO);
    User update(UserDTO userDTO, Long id);
    User patch(UserDTO userDTO, Long id);
    void delete(Long id);
    
}
