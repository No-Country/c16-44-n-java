package com.marketplace.usersservice.repository;

import com.marketplace.usersservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    @Query("SELECT p FROM product p ORDER BY p.name ASC")
    List<Product> findAllOrderedByNameAsc();
    @Query("SELECT p FROM product p ORDER BY p.name DESC")
    List<Product> findAllOrderedByNameDesc();
}
