package com.gal.proyecto.springboot.inventary_pro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="El nombre no debe ser vacío")
    private String name;
    
    @NotEmpty(message="La descripción no debe ser vacía")
    private String description;
    
    @Min(value = 1, message = "El precio debe ser mayor que 0")
    private Double price;
    
    @Min(value = 1, message = "La cantidad debe ser mayor que 0")
    private Long quantity;
}