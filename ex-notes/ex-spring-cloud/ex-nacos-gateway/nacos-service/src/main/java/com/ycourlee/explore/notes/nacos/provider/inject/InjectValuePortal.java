package com.ycourlee.explore.notes.nacos.provider.inject;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yooonn
 * @date 2022.01.11
 */
@Setter
@Getter
@Component
@RefreshScope
public class InjectValuePortal {

    private static final Logger log = LoggerFactory.getLogger(InjectValuePortal.class);

    @Value("#{'${complex-${string${x}}}'}")
    private String complexString;

    @Value("#{${longest.time.two-route}}")
    private Map<Long, Integer> twoRouteLongestTime;
}
