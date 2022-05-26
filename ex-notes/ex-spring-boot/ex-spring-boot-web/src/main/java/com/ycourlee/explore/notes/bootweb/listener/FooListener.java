package com.ycourlee.explore.notes.bootweb.listener;

import com.ycourlee.explore.notes.bootweb.context.ApplicationEventPublisherHolder;
import com.ycourlee.explore.notes.bootweb.event.FooEvent;
import com.ycourlee.explore.notes.bootweb.event.FooRequestProcessingEvent;
import com.ycourlee.explore.notes.bootweb.event.FooRequestProcessingNestedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.CompletableFuture;

/**
 * @author yooonn
 * @date 2022.03.28
 */
@Component
public class FooListener extends ApplicationEventPublisherHolder {

    private static final Logger log = LoggerFactory.getLogger(FooListener.class);

    @EventListener
    public void subscribeFooRequestProcessingEvent(FooRequestProcessingEvent event) {
        log.info("event.getUri(): {}", event.getUri());

        CompletableFuture.runAsync(() -> publisher.publishEvent(new FooRequestProcessingNestedEvent("haha")));
    }

    @EventListener
    public void subscribeFooRequestProcessingEvent2(FooRequestProcessingEvent event) {
        try {
            log.info("event.getUri(): {}", event.getUri());
            throw new IllegalArgumentException();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @EventListener
    public void subscribeFooRequestProcessingNestedEvent(FooRequestProcessingNestedEvent event) {
        log.info(event.toString());
    }

    @TransactionalEventListener
    public void subscribeFooEventTransactional(FooEvent event) {
        log.info(event.toString());
    }

    @EventListener
    public void subScribeFooEvent(FooEvent event) {
        log.info(event.toString());
    }
}
