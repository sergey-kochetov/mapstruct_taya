package com.example.mapstruct_taya.controller;

import com.example.mapstruct_taya.validator.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@NoArgsConstructor
public class AdviceController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<Object> handleApplicationException(Exception ex, WebRequest request) {
        ApplicationException ae = (ApplicationException) ex;
        ApiErrorResponse response = ApiErrorResponse.valueOf(ae.getErrorCode(), ae.getMessage());
        return this.prepareResponse(ae.getStatus(), response);
    }

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception ex) {
        DataNotFoundException dfe = (DataNotFoundException) ex;
        ApiErrorResponse response = ApiErrorResponse.valueOf(dfe.getErrorCode(), dfe.getMessage());
        return this.prepareResponse(dfe.getStatus(), response);
    }

    @ExceptionHandler({ProductValidatorException.class})
    public ResponseEntity<Object> handleProductValidatorException(Exception ex) {
        ProductValidatorException pve = (ProductValidatorException) ex;
        ApiErrorResponse response = ApiErrorResponse.valueOf(pve.getErrorCode(), pve.getMessage());
        return this.prepareResponse(pve.getStatus(), response);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<Object> handleAuthenticationException(Exception ex) {
        AuthenticationException au = (AuthenticationException)ex;
        ApiErrorResponse response = ApiErrorResponse.valueOf(au.getErrorCode(), au.getMessage());
        return this.prepareResponse(au.getStatus(), response);
    }

    protected ResponseEntity<Object> prepareResponse(HttpStatus status, ApiErrorResponse response) {
        return new ResponseEntity(response, new HttpHeaders(), status);
    }
}
