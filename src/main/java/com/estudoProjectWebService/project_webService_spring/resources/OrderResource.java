package com.estudoProjectWebService.project_webService_spring.resources;

import com.estudoProjectWebService.project_webService_spring.entities.Order;
import com.estudoProjectWebService.project_webService_spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orderList = service.findAll();
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order orderObj) {
        orderObj = service.insert(orderObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderObj.getId()).toUri();
        return ResponseEntity.created(uri).body(orderObj);
    }
}
