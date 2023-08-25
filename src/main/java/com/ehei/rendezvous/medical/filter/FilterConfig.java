package com.ehei.rendezvous.medical.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<PageAccessFilter> pageAccessFilterRegistration() {
        FilterRegistrationBean<PageAccessFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new PageAccessFilter());
        registration.addUrlPatterns("/list/","/login"); // Adjust the URL patterns as needed
        return registration;
    }
}
