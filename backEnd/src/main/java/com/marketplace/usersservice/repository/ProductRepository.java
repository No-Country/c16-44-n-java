package com.marketplace.usersservice.repository;

import com.marketplace.usersservice.model.Product;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    Page<Product> findAllByOrderByPriceAsc(Pageable pageable);
    Page<Product> findAllByOrderByPriceDesc(Pageable pageable);
    @Query("SELECT p FROM product p ORDER BY p.name ASC")
    Page<Product> findAllOrderedByNameAsc(Pageable pageable);
    @Query("SELECT p FROM product p ORDER BY p.name DESC")
    Page<Product> findAllOrderedByNameDesc(Pageable pageable);
    //@Query("SELECT p FROM product p WHERE p.product_category_id.name = :name")
    @Query("SELECT p FROM product p WHERE p.productCategory.name = :name")
    List<Product> findByCategory(String name);
    @Query("SELECT p FROM product p WHERE p.name LIKE %:text% ORDER BY p.id ASC LIMIT 10")
    List<Product> findByText(String text);
}
