package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.ProductDTO;
import com.marketplace.usersservice.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface IProductService {

    List<Product> getAllProducts();
    Product saveProduct(ProductDTO product);
    void deleteProduct(Long product_id);
    Optional<Product> findProductById(Long product_id);
    List<Product> getProductsOrderedByPrice();
    List<Product> getProductsOrderedByPriceASC();
    List<Product> getAllProductsOrderedByNameAsc();
    public List<Product> getAllProductsOrderedByNameDesc();
    void saveImages(MultipartFile mainFile, List<MultipartFile> files, Long productId);
}
