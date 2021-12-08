package com.ycourlee.explore.bootprocess.explorations.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
@Component
public class SampleListener implements ApplicationListener<SampleEvent> {

    private static final Logger log = LoggerFactory.getLogger(SampleListener.class);

    @Override
    public void onApplicationEvent(SampleEvent event) {
        log.info("event.getSource(): {}", System.lineSeparator() + JSON.toJSONString(event.getSource(), SerializerFeature.PrettyFormat));
    }
}
