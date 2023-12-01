package top.yooonn.explore.notes.bootweb.interceptor;

import lombok.Builder;

import java.util.UUID;

/**
 * @author yooonn
 * @date 2022.01.10
 */
@Builder
public class RequestContext {

    private static final ThreadLocal<RequestContext> contextThreadLocal = new ThreadLocal<>();

    private String rid;
    private String uri;
    private String body;

    public RequestContext() {
    }

    public RequestContext(String rid, String uri, String body) {
        this.rid = UUID.randomUUID().toString();
        this.uri = uri;
        this.body = body;
        clean();
        contextThreadLocal.set(this);
    }

    public static String getRid() {
        return contextThreadLocal.get().rid;
    }

    public static String getUri() {
        return contextThreadLocal.get().uri;
    }

    public static String getBody() {
        return contextThreadLocal.get().body;
    }

    public static void clean() {
        contextThreadLocal.remove();
    }
}
