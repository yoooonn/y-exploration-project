package com.ycourlee.explore.springbootfreemarker;

import freemarker.cache.TemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.io.StringReader;

/**
 * @author yooonn
 */
@Component
public class RedisStringTemplateLoader implements TemplateLoader {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void closeTemplateSource(Object templateSource) {
    }

    @Override
    public Object findTemplateSource(String name) {
        // String templateContent = redisTemplate.opsForValue().get(name);
        String templateContent = "{\"params\":{\"bikes\":[<#list gpsList><#items as gps>{\"operate\":3,\"qr_code\":\"${gps.qrCode}\",\"location\":\"${gps.lonLat}\",\"bike_frame\":\"${gps.bikeFrame}\"}<#sep>,</#sep></#items></#list>],\"city_id\":\"${cityId}\"}}";
        return new RedisStringTemplateSource(name, templateContent, -1L);
    }

    @Override
    public long getLastModified(Object templateSource) {
        return ((RedisStringTemplateSource) templateSource).lastModified;
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) {
        return new StringReader(((RedisStringTemplateSource) templateSource).templateContent);
    }

    private static class RedisStringTemplateSource {

        private final String name;
        private final String templateContent;
        private final long   lastModified;

        RedisStringTemplateSource(String name, String templateContent, long lastModified) {
            if (name == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (templateContent == null) {
                throw new IllegalArgumentException("source == null");
            }
            if (lastModified < -1L) {
                throw new IllegalArgumentException("lastModified < -1L");
            }
            this.name = name;
            this.templateContent = templateContent;
            this.lastModified = lastModified;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            RedisStringTemplateSource other = (RedisStringTemplateSource) obj;
            return name.equals(other.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
