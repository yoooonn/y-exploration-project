package com.ycourlee.explore.notes.bootweb.filter;

import com.ycourlee.explore.notes.bootweb.wrapper.BodySerialHttpServletRequestWrapper;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yongjiang
 * @date 2021.09.11
 */
public class BodyPersistenceFilter extends OncePerRequestFilter implements OrderedFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (!(request instanceof MultipartHttpServletRequest) && !(request instanceof BodySerialHttpServletRequestWrapper)) {
            BodySerialHttpServletRequestWrapper requestWrapper = new BodySerialHttpServletRequestWrapper(request);
            filterChain.doFilter(requestWrapper, response);
        } else if (request instanceof MultipartHttpServletRequest) {
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public int getOrder() {
        return OrderedFilter.HIGHEST_PRECEDENCE + 1;
    }
}
