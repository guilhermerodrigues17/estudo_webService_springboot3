package com.estudoProjectWebService.project_webService_spring.repositories;

import com.estudoProjectWebService.project_webService_spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
