package com.marketplace.productsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.productsservice.service.ProductService;

@RestController
@RequestMapping ("/v1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/saveImages")
    public ResponseEntity<?> saveImages(
        @RequestParam("images") List<MultipartFile> files,
        @RequestParam("publicationId") Long productId,
        @RequestParam("mainImage") MultipartFile mainFile) {
        try {
            
            productService.saveImages(mainFile, files, productId);
            
            return new ResponseEntity<>(HttpStatus.OK);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }






}

