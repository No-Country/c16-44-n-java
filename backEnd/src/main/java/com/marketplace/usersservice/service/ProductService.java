package com.marketplace.usersservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.usersservice.dto.ProductDTO;
import com.marketplace.usersservice.model.Image;
import com.marketplace.usersservice.model.Product;
import com.marketplace.usersservice.model.ProductCategory;
import com.marketplace.usersservice.repository.ImageRepository;
import com.marketplace.usersservice.repository.ProductCategoryRepository;
import com.marketplace.usersservice.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ImageRepository ImageRepository;

    @Autowired
    private CloudinaryService cloudinaryService;
    

    @Transactional
    public void saveImages(MultipartFile mainFile, List<MultipartFile> files, Long productId) {
        String folder = "NCproducts";
        
        //Montaje imagenes en Cloudinary
        Map result = cloudinaryService.upload(mainFile, folder);
        Image mainImage = new Image(result.get("public_id").toString(), 
            result.get("secure_url").toString());

        List<Image> images = new ArrayList<Image>();
        for (MultipartFile file : files) {
            //Posible montaje simultaneo de imagenes para mayor velocidad
            result = cloudinaryService.upload(file, folder);
            Image image = new Image(result.get("public_id").toString(), 
                result.get("secure_url").toString());
            images.add(image);
        }
        ImageRepository.save(mainImage);
        
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setBrand(productDTO.getBrand());

        ProductCategory productCategory;
           if (productDTO.getCategory()!= null && productDTO.getCategory().getId() != null) {
                productCategory = productCategoryRepository.findById(productDTO.getCategory().getId()).orElseThrow(() -> new IllegalArgumentException("ProductCategory with ID " + productDTO.getCategory().getId() + " not found."));

            } else {
                productCategory = ProductCategory.getDefaultProductCategory();
            }
           product.setCategory(productCategory);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long product_id) {
        productRepository.deleteById(product_id);
    }

    @Override
    public Optional<Product> findProductById(Long product_id) {
        return productRepository.findById(product_id);
    }

    @Override
    public List<Product> getProductsOrderedByPrice(){
        return productRepository.findAllByOrderByPriceAsc();
    }
    @Override
    public List<Product> getProductsOrderedByPriceASC() {
       return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Product> getAllProductsOrderedByNameAsc() {
        return productRepository.findAllOrderedByNameAsc();
    }
    @Override
    public List<Product> getAllProductsOrderedByNameDesc() {
        return productRepository.findAllOrderedByNameDesc();
    }


}
