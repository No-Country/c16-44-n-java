package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dtos.UserDTO;
import com.marketplace.usersservice.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    public User save(UserDTO user);
    public User update(UserDTO userDTO, Long id);
    public User patch(UserDTO userDTO, Long id);
    void delete(Long id);

}
