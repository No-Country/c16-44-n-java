
package com.marketplace.usersservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PutMapping("/update/{id}")
    public Product update(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        return productService.updateProduct(productDTO, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    @GetMapping("/search/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<?>> findAllProduct(@RequestParam int page) {
        return ResponseEntity.ok(productService.getAllProducts(page));
    }

    @GetMapping("/low-to-high")
    public ResponseEntity<Page<?>>  showLowestToHighestPrices(@RequestParam int page){
        return ResponseEntity.ok(productService.getProductsOrderedByPriceASC(page));
    }
    @GetMapping("/high-to-low")
    public ResponseEntity<Page<?>>  showHighestToLowetsPrices(@RequestParam int page){
        return ResponseEntity.ok(productService.getProductsOrderedByPrice(page));
    }
    @GetMapping("/ordered-by-name-asc")
    public ResponseEntity<Page<?>>  showOrderedByNameASC(@RequestParam int page){
        return ResponseEntity.ok(productService.getAllProductsOrderedByNameAsc(page));
    }
    @GetMapping("/ordered-by-name-des")
    public ResponseEntity<Page<?>>  showOrderedByNameDES(@RequestParam int page){
        return ResponseEntity.ok(productService.getAllProductsOrderedByNameDesc(page));
    }






}

