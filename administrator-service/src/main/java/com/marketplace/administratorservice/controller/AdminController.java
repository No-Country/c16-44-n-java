package com.marketplace.administratorservice.controller;

import com.marketplace.administratorservice.entity.AdminEntity;
import com.marketplace.administratorservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public ResponseEntity<List<AdminEntity>> getAllAdmin(){
        List<AdminEntity> admins = adminRepository.findAll();
        if(admins.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createAdmin(@RequestBody AdminEntity adminEntity){
        adminRepository.save(adminEntity);
    }
}
