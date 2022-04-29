package com.ycourlee.explore.notes.nacos.provider.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yongjiang
 * @date 2022.01.22
 */
public class ReceivedRequestEvent extends ApplicationEvent {

    private static final long serialVersionUID = -7185387886268734876L;

    public ReceivedRequestEvent(HttpServletRequest source) {
        super(source);
    }
}
