package com.challenge.application01.exceptions;




import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challenge.application01.utils.LoggerUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerUtil.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        log.warn("[NOT FOUND] {}", ex.getMessage());
        return ResponseEntity.status(404).body(new ErrorResponse(404, ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(IllegalArgumentException ex){
        log.warn("[BAD REQUEST] {}", ex.getMessage());
        return ResponseEntity.status(400).body(new ErrorResponse(400, ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex){
        log.warn("[RUNTIME] {}", ex.getMessage());
        return ResponseEntity.status(500).body(new ErrorResponse(500, "Erro do servidor"));
    }

     @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        log.error("[INTERNAL ERROR] {} — causa: {}", ex.getMessage(), ex.getCause(), ex);
         return ResponseEntity.status(500).body(new ErrorResponse(500, "Erro do servidor"));
    }
}
