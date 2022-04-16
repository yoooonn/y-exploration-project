package com.ycourlee.explore.bootprocess.chain.followchain;

import com.ycourlee.root.core.domain.context.Rtm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
@Component
public class ChainDelegator implements FollowChain {

    @Autowired
    private List<Follow> follows;

    @PostConstruct
    private void postConstruct() {
        follows.sort(Comparator.comparingInt(Follow::order));
    }

    @Override
    public void doExecute(Rtm rtm, RuleData ruleData) {
        new DefaultFollowChain(follows).doExecute(rtm, ruleData);
    }
}
