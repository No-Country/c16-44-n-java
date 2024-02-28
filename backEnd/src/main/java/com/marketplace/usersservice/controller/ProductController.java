
package com.marketplace.usersservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.usersservice.dto.ProductDTO;
import com.marketplace.usersservice.model.Product;
import com.marketplace.usersservice.service.IProductService;
import com.marketplace.usersservice.service.ProductService;

@RestController
@RequestMapping ("/v1/product")
public class ProductController {
    
    @Autowired
    private IProductService productService;

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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/search/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/low-to-high")
    public ResponseEntity<?>  showLowestToHighestPrices(){
        return ResponseEntity.ok(productService.getProductsOrderedByPriceASC());
    }
    @GetMapping("/high-to-low")
    public ResponseEntity<?>  showHighestToLowetsPrices(){
        return ResponseEntity.ok(productService.getProductsOrderedByPrice());
    }
    @GetMapping("/ordered-by-name-asc")
    public ResponseEntity<?>  showOrderedByNameASC(){
        return ResponseEntity.ok(productService.getAllProductsOrderedByNameAsc());
    }
    @GetMapping("/ordered-by-name-des")
    public ResponseEntity<?>  showOrderedByNameDES(){
        return ResponseEntity.ok(productService.getAllProductsOrderedByNameDesc());
    }






}

