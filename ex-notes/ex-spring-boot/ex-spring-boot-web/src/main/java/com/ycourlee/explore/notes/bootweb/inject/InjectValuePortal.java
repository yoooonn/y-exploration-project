package com.ycourlee.explore.notes.bootweb.inject;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yongjiang
 * @date 2022.01.11
 */
@Setter
@Getter
@Component
public class InjectValuePortal {

    private static final Logger log = LoggerFactory.getLogger(InjectValuePortal.class);

    @Value("#{@injectValueRender.setList(${invokeBeanMethod.numbers})}")
    private String listConfig;

    @Value("#{@injectValueRender.setCat(${catConfig.json:'[]'})}")
    private String catConfig;

    @Value("#{'${complex-${string${x}}}'}")
    private String complexString;

    @Value("#{${longest.time.two-route}}")
    private Map<Long, Integer> twoRouteLongestTime;
}
