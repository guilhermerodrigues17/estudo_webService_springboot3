package com.estudoProjectWebService.project_webService_spring.repositories;

import com.estudoProjectWebService.project_webService_spring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
