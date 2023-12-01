package top.yooonn.explore.notes.bootweb.listener.annotationbased;

import top.yooonn.explore.notes.bootweb.annotation.AsyncEventListener;
import top.yooonn.explore.notes.bootweb.context.ApplicationContext;
import top.yooonn.explore.notes.bootweb.event.SimpleEvent;
import com.ycourlee.tranquil.redisson.annotation.Lockable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author yooonn
 * @date 2022.03.14
 */
@Component(value = "com.ycourlee.explore.notes.bootweb.listener.annotationbased.SimpleListener")
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

    @Lockable(keys = "boot:lock:test:{{event}}")
    public void lockTest(String event) {
        log.info("event: {}", event);
    }
}
