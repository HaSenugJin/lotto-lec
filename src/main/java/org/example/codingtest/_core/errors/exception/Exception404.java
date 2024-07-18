package org.example.codingtest._core.errors.exception;

import org.example.codingtest._core.utils.ApiUtil;
import org.springframework.http.HttpStatus;

public class Exception404 extends RuntimeException {
    public Exception404(String reason) {
        super(reason);
    }

    public ApiUtil<?> body() {
        return ApiUtil.error(getMessage(), HttpStatus.NOT_FOUND);
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}