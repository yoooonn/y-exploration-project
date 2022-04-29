package com.ycourlee.explore.notes.bootweb.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
@Setter
@Getter
@ToString
public class FooRequestProcessingEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7893670289273702917L;

    private Object[] param;

    private String uri;

    public FooRequestProcessingEvent(String uri, Object[] param) {
        super(uri);
        this.uri = uri;
        this.param = param;
    }
}
