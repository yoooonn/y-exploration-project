package com.ycourlee.explore.bootprocess.explorations.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
public class SampleEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4842779781507005320L;

    public SampleEvent(Object source) {
        super(source);
    }
}
