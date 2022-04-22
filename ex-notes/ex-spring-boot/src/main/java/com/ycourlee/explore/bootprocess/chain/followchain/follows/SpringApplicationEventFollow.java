package com.ycourlee.explore.bootprocess.chain.followchain.follows;

import com.ycourlee.explore.bootprocess.chain.followchain.Follow;
import com.ycourlee.explore.bootprocess.chain.followchain.FollowChain;
import com.ycourlee.explore.bootprocess.chain.followchain.RuleData;
import com.ycourlee.explore.bootprocess.event.SimpleEvent;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
@Component
public class SpringApplicationEventFollow implements Follow {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public int order() {
        return 0;
    }

    @Override
    public boolean disabled() {
        return true;
    }

    @Override
    public void doExecute(Response resp, RuleData ruleData, FollowChain chain) {
        resp.data("hello");
        applicationEventPublisher.publishEvent(new SimpleEvent(resp));
        chain.doExecute(resp, ruleData);
    }
}
