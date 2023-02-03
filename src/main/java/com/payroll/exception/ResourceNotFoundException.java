package com.payroll.exception;

public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String fieldName;
    public Long fieldValue;

    public ResourceNotFoundException(String message){
        super(message);

    }

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue){
        super(String.format("%s with %s:%s not found",resourceName,fieldName,fieldValue));

    }
}
