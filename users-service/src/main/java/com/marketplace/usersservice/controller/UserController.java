package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.dtos.UserDTO;
import com.marketplace.usersservice.model.User;
import com.marketplace.usersservice.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
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


