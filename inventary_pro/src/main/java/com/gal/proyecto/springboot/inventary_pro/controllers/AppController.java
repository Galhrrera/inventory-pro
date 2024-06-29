package com.gal.proyecto.springboot.inventary_pro.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;
import com.gal.proyecto.springboot.inventary_pro.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;



@RestController
@RequiredArgsConstructor
@RequestMapping("/app/inventari-pro/api")
public class AppController {

    private final ProductService productService;

    @Value("${product.added}")
    private String productAdded;

    @GetMapping("/hola-mundo")
    public ResponseEntity<?> holaMundo() {
        return ResponseEntity.ok().body("Hola mundo");
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProdcut(@Valid @RequestBody Product product) {
        
        Product savedProduct = productService.saveProduct(product);

        Map<String, Object> response = new HashMap<>();

        response.put("Message", productAdded);
        response.put("Product", savedProduct);

        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    
}
