package org.example.codingtest._core.config;

import org.example.codingtest._core.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> loggingFilter(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");

        // "/h2-console" URL을 제외하도록 설정
        registrationBean.addUrlPatterns("/h2-console/*");
        registrationBean.setEnabled(false); // 필터 비활성화

        return registrationBean;
    }
}
