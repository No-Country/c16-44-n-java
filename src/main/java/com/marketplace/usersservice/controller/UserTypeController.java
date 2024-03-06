package com.marketplace.usersservice.controller;

import com.marketplace.usersservice.dto.UserTypeDTO;
import com.marketplace.usersservice.model.UserType;
import com.marketplace.usersservice.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user-type")
@CrossOrigin(origins = "*")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    @PostMapping("/create")
    public UserType save(@RequestBody UserTypeDTO userTypeDTO) {
        try {
            return userTypeService.save(userTypeDTO);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error creating user type: " + ex.getMessage());
        }
    }
}
