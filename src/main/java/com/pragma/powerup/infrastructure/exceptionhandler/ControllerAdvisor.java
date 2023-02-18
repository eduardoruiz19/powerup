package com.pragma.powerup.infrastructure.exceptionhandler;

import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        System.out.println("llega Excepcion:"+exception.getClass().toString());
        String txtMensaje = "";
        String txtException = "";
        switch (exception.getClass().toString()) {
            case "class com.pragma.powerup.infrastructure.exception.UserDocumentoIdentidadAlreadyExistException":
                txtMensaje = "Error";
                txtException = "Document Identity Already Exist ";

                break;

            case "class org.springframework.dao.DataIntegrityViolationException":
                txtMensaje = "Error";
                txtException = "Key Field already Exist";
                //txtException = exception.getClass().toString();
                break;
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Collections.singletonMap(exception.getClass().toString(), exception.getMessage()));

        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(txtMensaje, txtException));


    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

}