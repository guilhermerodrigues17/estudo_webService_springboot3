package com.estudoProjectWebService.project_webService_spring.service;

import com.estudoProjectWebService.project_webService_spring.entities.Order;
import com.estudoProjectWebService.project_webService_spring.repositories.OrderRepository;
import com.estudoProjectWebService.project_webService_spring.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order orderObj) {
        return repository.save(orderObj);
    }
}
