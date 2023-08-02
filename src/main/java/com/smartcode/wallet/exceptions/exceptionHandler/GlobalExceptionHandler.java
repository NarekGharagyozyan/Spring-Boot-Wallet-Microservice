package com.smartcode.wallet.exceptions.exceptionHandler;

import com.smartcode.wallet.exceptions.DuplicationException;
import com.smartcode.wallet.exceptions.ResourceNotFoundException;
import com.smartcode.wallet.util.exceptionHandlerResponse.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> notFoundException(HttpServletRequest req, ResourceNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(DuplicationException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> runtimeException(HttpServletRequest req, DuplicationException e) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> runtimeException(HttpServletRequest req, RuntimeException e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), req.getRequestURI());
    }

    private ResponseEntity<ApiError> buildResponse(HttpStatus httpStatus, String message, String uri) {
        var errors = new HashMap<String, String>();
        errors.put("message", message);
        var apiError = new ApiError(httpStatus.value(), uri,errors);
        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
