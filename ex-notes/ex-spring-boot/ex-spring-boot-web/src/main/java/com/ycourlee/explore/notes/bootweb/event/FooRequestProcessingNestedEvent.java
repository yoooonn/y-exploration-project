package com.ycourlee.explore.notes.bootweb.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yongjiang
 * @date 2022.04.11
 */
public class FooRequestProcessingNestedEvent extends ApplicationEvent {

    public FooRequestProcessingNestedEvent(Object source) {
        super(source);
    }
}