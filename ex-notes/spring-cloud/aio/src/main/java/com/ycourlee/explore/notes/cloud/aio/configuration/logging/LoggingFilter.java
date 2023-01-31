package com.ycourlee.explore.notes.cloud.aio.configuration.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yooonn
 * @date 2023.01.29
 */
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger("G-logger");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        if (isJsonRequest(request)) {
            if (!(request instanceof PersistableJsonBodyHttpServletRequest)) {
                request = new PersistableJsonBodyHttpServletRequest(request);
            }
            PersistableJsonBodyHttpServletRequest req = (PersistableJsonBodyHttpServletRequest) request;
            log.info("r {} {}", request.getRequestURI(), req.getJsonBody());
        }
        if (!(response instanceof PersistableJsonBodyHttpServletResponse)) {
            response = new PersistableJsonBodyHttpServletResponse(response);
        }
        filterChain.doFilter(request, response);
        if (isJsonResponse(response)) {
            PersistableJsonBodyHttpServletResponse resp = (PersistableJsonBodyHttpServletResponse) response;
            log.info("R {} {} {}ms", request.getRequestURI(), resp.getJsonBody(), System.currentTimeMillis() - start);
        }
    }

    private boolean isJsonResponse(HttpServletResponse response) {
        return isJsonContent(response.getContentType());
    }

    private boolean isJsonRequest(HttpServletRequest request) {
        return isJsonContent(request.getContentType());
    }

    private boolean isJsonContent(String contentType) {
        if (StringUtils.isEmpty(contentType)) {
            return false;
        }
        return MimeTypeUtils.APPLICATION_JSON.isCompatibleWith(MimeTypeUtils.parseMimeType(contentType.split(";")[0].trim()));
    }
}
