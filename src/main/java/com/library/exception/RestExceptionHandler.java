package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(value = { IOException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse throwBadRequestException(Exception ex)
    {
        return new ErrorResponse(400, "Bad Request");
    }
    
    @ExceptionHandler(value = { RuntimeException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse throwNotFoundException(RuntimeException ex)
    {
        return new ErrorResponse(404, "Book Not Found");
    }
}