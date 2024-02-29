package com.marketplace.usersservice.service;

import com.marketplace.usersservice.dto.ProductDTO;
import com.marketplace.usersservice.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface IProductService {

    Page<Product> getAllProducts(int page);
    Product saveProduct(ProductDTO product);
    Product updateProduct(ProductDTO product, Long id);
    void deleteProduct(Long product_id);
    Optional<Product> findProductById(Long product_id);
    Page<Product> getProductsOrderedByPrice(int page);
    Page<Product> getProductsOrderedByPriceASC(int page);
    Page<Product> getAllProductsOrderedByNameAsc(int page);
    Page<Product> getAllProductsOrderedByNameDesc(int page);
    void saveImages(MultipartFile mainFile, List<MultipartFile> files, Long productId);
}
