package com.gal.proyecto.springboot.inventary_pro.services;

import org.springframework.data.domain.Page;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;

public interface ProductService {

    Product saveProduct(Product product);

    Page<Product> getProducts(int pageNumber, int pageSize, String sortBy);

    Product findById(Long id);

    Product findByName(String name);

    Product updateProduct(Long id, Product product);
}
