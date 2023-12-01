package top.yooonn.explore.notes.bootweb.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yooonn
 * @date 2022.04.18
 */
public class FooEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7464702115019472287L;

    public FooEvent(Object source) {
        super(source);
    }
}
