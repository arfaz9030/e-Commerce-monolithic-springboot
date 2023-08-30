package com.tcs.ecommerce.ecommerceorderproduct.services.impl;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Product;
import com.tcs.ecommerce.ecommerceorderproduct.exceptions.ResourceNotFoundException;
import com.tcs.ecommerce.ecommerceorderproduct.repositories.ProductRepo;
import com.tcs.ecommerce.ecommerceorderproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        Product savedProduct= productRepo.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
         product = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
        this.productRepo.delete(product);

    }

    @Override
    public Product getProductById(Long productId) {
        Product product  = this.productRepo.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
        return(product);
    }



}
