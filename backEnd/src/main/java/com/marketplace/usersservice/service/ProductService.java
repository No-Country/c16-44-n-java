package com.marketplace.usersservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setBrand(productDTO.getBrand());
        product.setUser(productDTO.getUser());

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
    public Product updateProduct(ProductDTO productDTO, Long id) {
        Product productToUpdate = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product with ID " + id + " not found."));
        productToUpdate.setName(productDTO.getName());
        productToUpdate.setPrice(productDTO.getPrice());
        productToUpdate.setStock(productDTO.getStock());
        productToUpdate.setDescription(productDTO.getDescription());
        productToUpdate.setBrand(productDTO.getBrand());
        productToUpdate.setImage(productDTO.getImage());
        productToUpdate.setCategory(productDTO.getCategory());


        return productRepository.save(productToUpdate);
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
    public Page<Product> getAllProducts(int page) {
        int size = 9;
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getProductsOrderedByPrice(int page){
        int size = 9;
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByOrderByPriceAsc(pageable);
    }
    @Override
    public Page<Product> getProductsOrderedByPriceASC(int page) {
        int size = 9;
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByOrderByPriceDesc(pageable);
    }

    @Override
    public Page<Product> getAllProductsOrderedByNameAsc(int page) {
        int size = 9;
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllOrderedByNameAsc(pageable);
    }
    @Override
    public Page<Product> getAllProductsOrderedByNameDesc(int page) {
        int size = 9;
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllOrderedByNameDesc(pageable);
    }


}
