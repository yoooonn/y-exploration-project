package com.ycourlee.explore.notes.bootweb.listener.interfacebased;

import com.ycourlee.explore.notes.bootweb.event.ReceivedRequestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yooonn
 * @date 2022.01.22
 */
@Component
public class ReceivedRequestEventListener implements ApplicationListener<ReceivedRequestEvent> {

    @Override
    public void onApplicationEvent(ReceivedRequestEvent event) {
        if (event.getSource() instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) event.getSource();
        }
    }
}
