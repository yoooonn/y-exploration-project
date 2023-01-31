package com.ycourlee.explore.notes.cloud.aio.watchpoint.impl;

import com.ycourlee.explore.notes.cloud.aio.watchpoint.Context;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPoint;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yooonn
 * @date 2023.01.29
 */
@Component
public class OncePerRequestFilterWatchPoint implements WatchPoint {

    private static final Logger log = LoggerFactory.getLogger(OncePerRequestFilterWatchPoint.class);

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        response.pin(getClass().getSimpleName(), "hi");
        chain.doExecute(response, context);
    }

    @Configuration
    public static class Config {

        // @Bean
        @Order(100)
        public Filter testOncePerRequestFilter() {
            return new TestOncePerRequestFilter();
        }

        // @Bean
        @Order(101)
        public Filter testFilter() {
            return new TestFilter();
        }
    }

    /**
     * javax.servlet低版本, 或者不同的实现, forward可能会有不同的行为, 会有一个Filter执行了多次的情况,
     * Spring Web实现了OncePerRequestFilter, 它通过对request加attribution来达到一个Filer从请求接受到响应只整体执行了一次(doFilterInternal内的doFilter行为不变)
     * <p>
     * 在tomcat 9,  servlet 3.0
     */
    public static class TestOncePerRequestFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            log.info("1");
            filterChain.doFilter(request, response);
            log.info("2");
            filterChain.doFilter(request, response);
            log.info("3");
        }
    }

    public static class TestFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            log.info("f 1");
            chain.doFilter(request, response);
            log.info("f 2");
            chain.doFilter(request, response);
            log.info("f 3");
        }
    }
}
