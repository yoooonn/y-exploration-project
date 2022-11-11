package com.ycourlee.explore.notes.nacos.provider.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yooonn
 * @date 2022.04.11
 */
public class FooRequestProcessingNestedEvent extends ApplicationEvent {

    public FooRequestProcessingNestedEvent(Object source) {
        super(source);
    }
}
