package top.yooonn.explore.notes.bootweb.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yooonn
 * @date 2022.01.22
 */
public class ReceivedRequestEvent extends ApplicationEvent {

    private static final long serialVersionUID = -7185387886268734876L;

    public ReceivedRequestEvent(HttpServletRequest source) {
        super(source);
    }
}
