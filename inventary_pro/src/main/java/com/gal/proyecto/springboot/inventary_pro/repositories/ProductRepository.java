package com.gal.proyecto.springboot.inventary_pro.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gal.proyecto.springboot.inventary_pro.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, PagingAndSortingRepository<Product, Long>{

    Optional<Product> findByName(String name);
    
}
