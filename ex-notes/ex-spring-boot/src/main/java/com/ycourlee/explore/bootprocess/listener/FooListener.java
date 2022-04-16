package com.ycourlee.explore.bootprocess.listener;

import com.ycourlee.explore.bootprocess.context.ApplicationEventPublisherHolder;
import com.ycourlee.explore.bootprocess.event.FooRequestProcessingEvent;
import com.ycourlee.explore.bootprocess.event.FooRequestProcessingNestedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author yongjiang
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

        }
    }

    @EventListener
    public void subscribeFooRequestProcessingNestedEvent(FooRequestProcessingNestedEvent event) {
        log.info(event.toString());
    }
}
