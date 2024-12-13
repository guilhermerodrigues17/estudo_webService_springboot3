package com.estudoProjectWebService.project_webService_spring.service;

import com.estudoProjectWebService.project_webService_spring.entities.Product;
import com.estudoProjectWebService.project_webService_spring.repositories.ProductRepository;
import com.estudoProjectWebService.project_webService_spring.service.exceptions.DatabaseException;
import com.estudoProjectWebService.project_webService_spring.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product productObj) {
        return repository.save(productObj);
    }

    public Product update(Long id, Product productObj) {
        try {
            Product updatedObj = repository.getReferenceById(id);
            updatedObj.setName(productObj.getName());
            updatedObj.setDescription(productObj.getDescription());
            updatedObj.setPrice(productObj.getPrice());
            updatedObj.setImgUrl(productObj.getImgUrl());
            if (!productObj.getCategories().isEmpty()) {
                updatedObj.getCategories().clear();
                updatedObj.getCategories().addAll(productObj.getCategories());
            }

            return repository.save(updatedObj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
