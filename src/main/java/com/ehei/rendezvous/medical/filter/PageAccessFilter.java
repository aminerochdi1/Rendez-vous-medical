package com.ehei.rendezvous.medical.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class PageAccessFilter implements Filter, jakarta.servlet.Filter {


    @Override
    public boolean isLoggable(LogRecord record) {
        return false;

    }

   // @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("loggedInPatient") != null) {
            // The patient is logged in, allow the request to proceed
            filterChain.doFilter(request, response);
        } else {
            // The patient is not logged in, redirect to login page or display an error message
            httpResponse.sendRedirect("/index"); // Adjust the URL to your login page
        }
    }

}
