package org.uam.serviceinventario.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdministradorException {

    private final String ERROR_TX = "error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException  ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    errors.put(error.getField(),error.getDefaultMessage());
                });
        return ResponseEntity
                .badRequest().body(errors.toString());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleAllExceptions(Exception ex) {
        Map<String,Object> error = new HashMap<>();
        error.put("error", "400");
        error.put("message", ex.getMessage());

        /*Throwable root = ex;
        while (root.getCause() != null) {
            root = root.getCause();
        }
        error.put("rootCause", root.toString());
        error.put("stackTrace", ex.getStackTrace());*/
        return error;
    }

    /*@ExceptionHandler(InventarioException.class)
    public ResponseEntity<?> handleInventarioException(InventarioException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "message", ex.getMessage(),
                        "status", 400
                ));
    }*/

}
