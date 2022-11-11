package com.ycourlee.explore.notes.bootweb.listener.interfacebased;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ycourlee.explore.notes.bootweb.event.SimpleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
 * @date 2021.11.30
 */
@Component
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    private static final Logger log = LoggerFactory.getLogger(SimpleListener.class);

    @Override
    public void onApplicationEvent(SimpleEvent event) {
        log.info("event.getSource(): {}", System.lineSeparator() + JSON.toJSONString(event.getSource(), SerializerFeature.PrettyFormat));
    }
}
