package com.ycourlee.explore.bootprocess.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ycourlee.explore.bootprocess.event.SimpleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
@Component
public class SampleListener implements ApplicationListener<SimpleEvent> {

    private static final Logger log = LoggerFactory.getLogger(SampleListener.class);

    @Override
    public void onApplicationEvent(SimpleEvent event) {
        log.info("event.getSource(): {}", System.lineSeparator() + JSON.toJSONString(event.getSource(), SerializerFeature.PrettyFormat));
    }
}
