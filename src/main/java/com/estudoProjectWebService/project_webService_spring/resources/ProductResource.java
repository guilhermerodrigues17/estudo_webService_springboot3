package com.estudoProjectWebService.project_webService_spring.resources;

import com.estudoProjectWebService.project_webService_spring.entities.Product;
import com.estudoProjectWebService.project_webService_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = service.findAll();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product productObj) {
        productObj = service.insert(productObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productObj.getId()).toUri();
        return ResponseEntity.created(uri).body(productObj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product productObj) {
        productObj = service.update(id, productObj);
        return ResponseEntity.ok().body(productObj);
    }
}
