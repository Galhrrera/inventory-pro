package com.gal.proyecto.springboot.inventary_pro.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;
import com.gal.proyecto.springboot.inventary_pro.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getProducts(int pageNumber, int pageSize, String sortBy) {
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        Product foundProduct = new Product();
        foundProduct.setId(null);
        optionalProduct.ifPresent(p -> {
            foundProduct.setId(p.getId());
            foundProduct.setName(p.getName());
            foundProduct.setDescription(p.getDescription());
            foundProduct.setPrice(p.getPrice());
            foundProduct.setQuantity(p.getQuantity());
        });

        return foundProduct;
    }

    @Override
    public Product findByName(String name) {
        Optional<Product> optionalProduct = productRepository.findByName(name);

        Product foundProduct = new Product();
        foundProduct.setId(null);
        optionalProduct.ifPresent(p -> {
            foundProduct.setId(p.getId());
            foundProduct.setName(p.getName());
            foundProduct.setDescription(p.getDescription());
            foundProduct.setPrice(p.getPrice());
            foundProduct.setQuantity(p.getQuantity());
        });

        return foundProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        
        if (optionalProduct.isPresent()){
            Product updateProduct = optionalProduct.orElseThrow();
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setQuantity(product.getQuantity());
            return productRepository.save(updateProduct);
        }
        else return new Product();
    }

}
