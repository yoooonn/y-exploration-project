package com.ycourlee.explore.notes.bootweb.event;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author yooonn
 * @date 2022.01.22
 */
@ToString
public class SimpleTransactionalEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4687756615646992078L;

    public SimpleTransactionalEvent(String message) {
        super(message);
    }
}
