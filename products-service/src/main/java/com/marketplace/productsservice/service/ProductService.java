package com.marketplace.productsservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.productsservice.entity.Image;
import com.marketplace.productsservice.repository.ImageRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
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

}
