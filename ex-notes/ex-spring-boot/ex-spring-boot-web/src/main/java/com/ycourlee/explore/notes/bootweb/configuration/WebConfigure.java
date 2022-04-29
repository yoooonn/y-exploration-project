package com.ycourlee.explore.notes.bootweb.configuration;

import com.ycourlee.explore.notes.bootweb.interceptor.BodyGlanceForDebugInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yongjiang
 * @date 2021.09.11
 */
@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Autowired
    private BodyGlanceForDebugInterceptor bodyGlanceForDebugInterceptor;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(bodyGlanceForDebugInterceptor)
                .addPathPatterns("/**");
    }
}
