package com.tcs.ecommerce.ecommerceorderproduct.repositories;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
