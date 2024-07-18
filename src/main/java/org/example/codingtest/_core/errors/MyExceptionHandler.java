package org.example.codingtest._core.errors;

import lombok.extern.slf4j.Slf4j;
import org.example.codingtest._core.errors.exception.Exception400;
import org.example.codingtest._core.errors.exception.Exception404;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> ex400(Exception400 e) {
        log.warn(e.getMessage());

        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> ex404(Exception404 e) {
        log.warn(e.getMessage());

        return new ResponseEntity<>(e.body(), e.status());
    }

}
