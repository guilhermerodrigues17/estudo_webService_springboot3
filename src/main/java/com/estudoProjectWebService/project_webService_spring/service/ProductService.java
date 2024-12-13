package com.estudoProjectWebService.project_webService_spring.service;

import com.estudoProjectWebService.project_webService_spring.entities.Product;
import com.estudoProjectWebService.project_webService_spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

    public Product insert(Product productObj) {
        return repository.save(productObj);
    }

    public Product update(Long id, Product productObj) {
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
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
