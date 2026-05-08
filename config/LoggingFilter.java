package edu.brooklyn.cisc3130.taskboard2.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;


@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger logging = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException{


        long startTime = System.currentTimeMillis();

        filterChain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;


        logging.info("{} {} - Status: {} - Duration: {}ms",
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus(),
                duration);
    }







    }







