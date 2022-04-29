package com.ycourlee.explore.notes.nacos.provider.model.request;

import com.ycourlee.explore.notes.nacos.provider.interceptor.RequestContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2022.01.10
 */
@Setter
@Getter
@ToString
public class BaseRequest {

    private String rid;

    private String uri;

    private String body;

    public BaseRequest() {
        this.rid = RequestContext.getRid();
        this.uri = RequestContext.getUri();
        this.body = RequestContext.getBody();
    }
}
