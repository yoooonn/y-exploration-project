package top.yooonn.explore.notes.bootweb.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yooonn
 * @date 2021.11.30
 */
public class SimpleEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4842779781507005320L;

    public SimpleEvent(Object source) {
        super(source);
    }
}
