package com.estudoProjectWebService.project_webService_spring.service;

import com.estudoProjectWebService.project_webService_spring.entities.User;
import com.estudoProjectWebService.project_webService_spring.repositories.UserRepository;
import com.estudoProjectWebService.project_webService_spring.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User userObj) {
        return repository.save(userObj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User userObj) {
        User entity = repository.getReferenceById(id);
        entity.setName(userObj.getName());
        entity.setEmail(userObj.getEmail());
        entity.setPhone(userObj.getPhone());

        return repository.save(entity);
    }
}
