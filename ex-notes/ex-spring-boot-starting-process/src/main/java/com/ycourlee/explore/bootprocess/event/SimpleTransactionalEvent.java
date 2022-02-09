package com.ycourlee.explore.bootprocess.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yongjiang
 * @date 2022.01.22
 */
public class SimpleTransactionalEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4687756615646992078L;

    public SimpleTransactionalEvent(String message) {
        super(message);
    }
}
