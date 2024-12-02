package com.estudoProjectWebService.project_webService_spring.repositories;

import com.estudoProjectWebService.project_webService_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
