package com.sistemi.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sistemi.exception.ErrorMessage;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorMessage notValidExceptionHandler(Exception ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                "hashTag size must be less than 12 characters", request.getDescription(false));
        return message;
    }
	
	@ExceptionHandler(ReadException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorMessage notReadExceptionHandler(Exception ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                ex.getMessage(), request.getDescription(false));
        return message;
    }
	
	@ExceptionHandler(SaveUpdateException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorMessage notSaveUpdateExceptionHandler(Exception ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(),
                ex.getMessage(), request.getDescription(false));
        return message;
    }
}
