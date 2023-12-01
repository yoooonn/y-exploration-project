package top.yooonn.explore.notes.bootweb.org.springframework.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

/**
 * @author yooonn
 */
public class AntPathMatcherTest {

    private static final Logger log = LoggerFactory.getLogger(AntPathMatcherTest.class);

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Test
    public void matchTest2() {
        log.info("pathMatcher.isPattern(\"/v1/lab/{id}\") = {}", pathMatcher.isPattern("/v1/lab/{id}"));
        log.info("pathMatcher.isPattern(\"/v1/lab/{id:[0-9]+}\") = {}", pathMatcher.isPattern("/v1/lab/{id:[0-9]+}"));

        log.info("pathMatcher.match(\"/v1/lab/{id}\", \"/v1/lab/a123\") = {}", pathMatcher.match("/v1/lab/{id}", "/v1/lab/a123"));
        log.info("pathMatcher.match(\"/v1/lab/{id}\", \"/v1/lab/123\") = {}", pathMatcher.match("/v1/lab/{id}", "/v1/lab/123"));

        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}\", \"/v1/lab/a123\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}", "/v1/lab/a123"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}\", \"/v1/lab/123\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}", "/v1/lab/123"));


        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/ab\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/ab"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/a\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/a"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/ab\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/ab"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/a\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/a"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/"));
        log.info("pathMatcher.match(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123\") = {}", pathMatcher.match("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123"));


        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/ab\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/ab"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/a\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/a"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123/\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123/"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]*}\", \"/v1/lab/123\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]*}", "/v1/lab/123"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/ab\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/ab"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/a\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/a"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123/\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123/"));
        log.info("pathMatcher.matchStart(\"/v1/lab/{id:[0-9]+}/{name:[a-z]+}\", \"/v1/lab/123\") = {}", pathMatcher.matchStart("/v1/lab/{id:[0-9]+}/{name:[a-z]+}", "/v1/lab/123"));
    }

    /**
     * <pre>
     * pathMatcher.match("/api/hello/*", "/api/hello/abc/") = false
     * pathMatcher.match("/api/hello/*", "/api/hello/abc") = true
     * pathMatcher.match("/api/hello/*", "/api/hello/abc/bdf") = false
     * pathMatcher.match("/api/hello/*", "/api/hello/abc/bdf/") = false
     * pathMatcher.match("/api/hello/**", "/api/hello/abc/") = true
     * pathMatcher.match("/api/hello/**", "/api/hello/abc") = true
     * pathMatcher.match("/api/hello/**", "/api/hello/abc/bdf") = true
     * pathMatcher.match("/api/hello/**", "/api/hello/abc/bdf/") = true
     *
     * 对于字符串左边的斜杠，无论单个星还是双星都不会匹配；
     * 右边的斜杠，单星不匹配，双星匹配
     *
     * 单星表示只匹配一级URL，双星表示匹配多级URL
     *
     * {@link AntPathMatcher#matchStart(java.lang.String, java.lang.String)} 按照最左匹配
     * {@link AntPathMatcher#match(java.lang.String, java.lang.String)} 全匹配
     *
     * <pre/>
     */
    @Test
    public void matchTest() {
        AntPathMatcher pathMatcher = new AntPathMatcher();


        log.info("pathMatcher.match(\"/api/hello/*\", \"/v2/api/hello/abc/\") = {}", pathMatcher.matchStart("/*/api/hello/*", "/v2/api/hello/abc/"));
        log.info("pathMatcher.match(\"/api/hello/*\", \"/v2/api/hello/abc\") = {}", pathMatcher.match("/*/api/hello/*", "/v2/api/hello/abc"));
        log.info("pathMatcher.match(\"/api/hello/*\", \"/v2/api/hello/abc/bdf\") = {}", pathMatcher.match("/api/hello/*", "/v2/api/hello/abc/bdf"));
        log.info("pathMatcher.match(\"/api/hello/*\", \"/v2/api/hello/abc/bdf/\") = {}", pathMatcher.match("/api/hello/*", "/v2/api/hello/abc/bdf/"));
        log.info("pathMatcher.match(\"/api/hello/**\", \"/v2/api/hello/abc/\") = {}", pathMatcher.match("/api/hello/**", "/v2/api/hello/abc/"));
        log.info("pathMatcher.match(\"/api/hello/**\", \"/v2/api/hello/abc\") = {}", pathMatcher.match("/api/hello/**", "/v2/api/hello/abc"));
        log.info("pathMatcher.match(\"/api/hello/**\", \"/v2/api/hello/abc/bdf\") = {}", pathMatcher.match("/api/hello/**", "/v2/api/hello/abc/bdf"));
        log.info("pathMatcher.match(\"/api/hello/**\", \"/v2/api/hello/abc/bdf/\") = {}", pathMatcher.match("/api/hello/**", "/v2/api/hello/abc/bdf/"));
    }

    @Test
    public void matchStartTest() {
        AntPathMatcher pathMatcher = new AntPathMatcher();

        log.info("pathMatcher.matchStart(\"/api/hello/*\", \"/api/hello/abc/\") = {}", pathMatcher.matchStart("/api/hello/*", "/api/hello/abc/"));
        log.info("pathMatcher.matchStart(\"/api/hello/*\", \"/api/hello/abc\") = {}", pathMatcher.matchStart("/api/hello/*", "/api/hello/abc"));
        log.info("pathMatcher.matchStart(\"/api/hello/*\", \"/api/hello/abc/bdf\") = {}", pathMatcher.matchStart("/api/hello/*", "/api/hello/abc/bdf"));
        log.info("pathMatcher.matchStart(\"/api/hello/*\", \"/api/hello/abc/bdf/\") = {}", pathMatcher.matchStart("/api/hello/*", "/api/hello/abc/bdf/"));
        log.info("pathMatcher.matchStart(\"/api/hello/**\", \"/api/hello/abc/\") = {}", pathMatcher.matchStart("/api/hello/**", "/api/hello/abc/"));
        log.info("pathMatcher.matchStart(\"/api/hello/**\", \"/api/hello/abc\") = {}", pathMatcher.matchStart("/api/hello/**", "/api/hello/abc"));
        log.info("pathMatcher.matchStart(\"/api/hello/**\", \"/api/hello/abc/bdf\") = {}", pathMatcher.matchStart("/api/hello/**", "/api/hello/abc/bdf"));
        log.info("pathMatcher.matchStart(\"/api/hello/**\", \"/api/hello/abc/bdf/\") = {}", pathMatcher.matchStart("/api/hello/**", "/api/hello/abc/bdf/"));
    }
}
