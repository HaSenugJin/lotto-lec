package org.example.codingtest._core.errors.exception;

import org.example.codingtest._core.utils.ApiUtil;
import org.springframework.http.HttpStatus;

public class Exception400 extends RuntimeException {

    public Exception400(String reason) {
        super(reason);
    }

    public ApiUtil<?> body() {
        return ApiUtil.error(getMessage(), HttpStatus.BAD_REQUEST);
    }

    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}