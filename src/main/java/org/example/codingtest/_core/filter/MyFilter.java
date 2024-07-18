package org.example.codingtest._core.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.regex.Pattern;

@Component
public class MyFilter implements Filter {
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9?&=:/]");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // "/h2-console" URL은 예외 처리 (필터를 건너뛰고 다음 필터로 진행)
        if (requestURI.startsWith("/h2-console")) {
            chain.doFilter(request, response);
            return;
        }

        // 특수 문자가 포함된 URL인 경우 예외 처리
        if (SPECIAL_CHAR_PATTERN.matcher(requestURI).find()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URL에 입력할 수 없는 문자가 들어갔습니다.");
        }

        // 다음 필터로 체인을 진행
        chain.doFilter(request, response);
    }
}
