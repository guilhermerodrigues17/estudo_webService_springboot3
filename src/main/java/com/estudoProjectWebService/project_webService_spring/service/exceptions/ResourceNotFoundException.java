package com.estudoProjectWebService.project_webService_spring.service.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id) {
        super("Id provided was not found! Id: " +  id);
    }

}
