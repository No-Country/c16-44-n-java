package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.dto.ProductDTO;
import com.marketplace.usersservice.dto.UserDTO;
import com.marketplace.usersservice.dto.UserLoginDTO;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody UserDTO userDTO) {
        try {
            return userService.save(userDTO);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error creating user: " + ex.getMessage());
        }
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.update(userDTO, id);
    }
    @PatchMapping("/patch/{id}")
    public User patch(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.patch(userDTO, id);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/search/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}


