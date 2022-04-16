package com.ycourlee.explore.bootprocess.listener.annotationbased;

import com.ycourlee.explore.bootprocess.annotation.AsyncEventListener;
import com.ycourlee.explore.bootprocess.context.ApplicationContext;
import com.ycourlee.explore.bootprocess.event.SimpleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author yongjiang
 * @date 2022.03.14
 */
@Component(value = "com.ycourlee.explore.bootprocess.listener.annotationbased.SimpleListener")
public class SimpleListener {

    private static final Logger log = LoggerFactory.getLogger(SimpleListener.class);

    @EventListener
    public void subscribeSimpleEvent(SimpleEvent event) {
        log.debug("Thread: {}", Thread.currentThread().getName());
        Assert.notNull(ApplicationContext.get());
        log.debug("SimpleListener.subscribeSimpleEvent: {}", event);
    }

    @AsyncEventListener
    public void subscribeSimpleEventAsync(SimpleEvent event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("Thread: {}", Thread.currentThread().getName());
        Assert.notNull(ApplicationContext.get());
        log.debug("SimpleListener.subscribeSimpleEventAsync: {}", event);
    }
}
