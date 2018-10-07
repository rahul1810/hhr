package com.heavenhr.heavenhr.controller;

import com.heavenhr.heavenhr.exception.ApplicationNotFoundException;
import com.heavenhr.heavenhr.exception.DataFormatException;
import com.heavenhr.heavenhr.exception.OfferNotFoundException;
import com.heavenhr.heavenhr.response.BaseResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

    @ResponseStatus(value= HttpStatus.CONFLICT,
            reason="Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="No relevant offer found")
    @ExceptionHandler(OfferNotFoundException.class)
    public void offerNotFound() {
        System.out.print("OfferNotFoundException");
        // Nothing to do
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="No relevant application found")
    @ExceptionHandler(ApplicationNotFoundException.class)
    public void applicationNotFound() {
        // Nothing to do
    }

    @ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE,
            reason="Invalid data format")
    @ExceptionHandler(DataFormatException.class)
    public void invalidFormat() {
        // Nothing to do
    }
}
