package top.yooonn.explore.notes.bootweb.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.lang.annotation.*;

/**
 * @author yooonn
 * @date 2022.03.25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Async("forEventListeners")
@EventListener
public @interface AsyncEventListener {
}
