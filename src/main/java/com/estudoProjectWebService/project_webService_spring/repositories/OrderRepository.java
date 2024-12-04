package com.estudoProjectWebService.project_webService_spring.repositories;

import com.estudoProjectWebService.project_webService_spring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
