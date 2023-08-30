package com.tcs.ecommerce.ecommerceorderproduct.controllers;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Product;
import com.tcs.ecommerce.ecommerceorderproduct.payloads.ApiResponse;
import com.tcs.ecommerce.ecommerceorderproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    public ProductService userService;

    //Get all products
    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> getProduct = userService.getAllProducts();
        return ResponseEntity.ok(getProduct);
    }
    // GET - user get
    @GetMapping("get-products/{userId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long userId) {
        return ResponseEntity.ok(this.userService.getProductById(userId));
    }
    // POST-create user
    @PostMapping("/add-user")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product userDto) {
        Product createProduct= this.userService.createProduct(userDto);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
    @PutMapping("/update-user/{userId}")
    public ResponseEntity<Product> updateProduct(@Validated @RequestBody Product userDto, @PathVariable("userId") Long uid) {
        Product updatedProduct = this.userService.updateProduct(userDto, uid);
        return ResponseEntity.ok(updatedProduct);
    }
    //Delete map
    @DeleteMapping("delete/{userId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("userId") Long uid) {
//     ResponseEntity<?> can be used above line for return type
        this.userService.deleteProduct(uid);
        return new ResponseEntity<>( new ApiResponse("Product deleted Successfully",true), HttpStatus.OK);
    }
}
