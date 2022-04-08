package com.divyansh.xharktank.exception;

import com.divyansh.xharktank.dto.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class ApiResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e) {
//        ApiResponse<Object> resp = ApiResponse.builder()
//                .message(e.getMessage())
//                .statusCode(HttpStatus.BAD_REQUEST)
//                .success(false)
//                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
