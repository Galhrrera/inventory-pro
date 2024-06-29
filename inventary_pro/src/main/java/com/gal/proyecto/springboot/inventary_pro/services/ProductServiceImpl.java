package com.gal.proyecto.springboot.inventary_pro.services;

import org.springframework.stereotype.Service;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;
import com.gal.proyecto.springboot.inventary_pro.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
