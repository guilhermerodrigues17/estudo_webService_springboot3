package com.estudoProjectWebService.project_webService_spring.repositories;

import com.estudoProjectWebService.project_webService_spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
