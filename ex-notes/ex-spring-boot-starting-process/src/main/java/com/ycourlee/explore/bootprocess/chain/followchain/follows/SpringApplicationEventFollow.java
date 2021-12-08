package com.ycourlee.explore.bootprocess.chain.followchain.follows;

import com.ycourlee.explore.bootprocess.chain.followchain.Follow;
import com.ycourlee.explore.bootprocess.chain.followchain.FollowChain;
import com.ycourlee.explore.bootprocess.chain.followchain.RuleData;
import com.ycourlee.explore.bootprocess.explorations.event.SampleEvent;
import com.ycourlee.root.core.domain.context.Rtm;
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
    public void doExecute(Rtm rtm, RuleData ruleData, FollowChain chain) {
        rtm.data("hello");
        applicationEventPublisher.publishEvent(new SampleEvent(rtm));
        chain.doExecute(rtm, ruleData);
    }
}
