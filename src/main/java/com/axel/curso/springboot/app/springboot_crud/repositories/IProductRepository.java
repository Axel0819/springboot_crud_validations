package com.axel.curso.springboot.app.springboot_crud.repositories;

import com.axel.curso.springboot.app.springboot_crud.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
