package com.gal.proyecto.springboot.inventary_pro.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;
import com.gal.proyecto.springboot.inventary_pro.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/inventari-pro/api")
public class AppController {

    private final ProductService productService;

    @Value("${product.added}")
    private String productAdded;

    @Value("${product.updated}")
    private String productUpdated;

    @Value("${product.not.updated}")
    private String productNotUpdated;

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

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) {

        Page<Product> products = productService.getProducts(pageNumber, pageSize, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);

        if (product.getId() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/products/by-name")
    public ResponseEntity<?> getProduct(@RequestParam(value = "name") String name) {
        Product product = productService.findByName(name);

        if (product.getId() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);

        Map<String, Object> response = new HashMap<>();

        if (updatedProduct == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productNotUpdated);
        else {
            response.put("Message", productUpdated);
            response.put("Product", updatedProduct);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

    }
}
