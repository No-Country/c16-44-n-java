package com.marketplace.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.productsservice.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String>{
    
}
