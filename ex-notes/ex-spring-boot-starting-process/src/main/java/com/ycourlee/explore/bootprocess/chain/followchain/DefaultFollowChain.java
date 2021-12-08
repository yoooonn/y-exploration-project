package com.ycourlee.explore.bootprocess.chain.followchain;

import com.ycourlee.explore.bootprocess.chain.AbstractElementChain;
import com.ycourlee.root.core.domain.context.Rtm;

import java.util.List;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
public class DefaultFollowChain extends AbstractElementChain<Rtm, RuleData, Follow> implements FollowChain {

    public DefaultFollowChain(List<Follow> follows) {
        super(follows);
    }

    @Override
    public void doExecute(Rtm rtm, RuleData ruleData) {
        if (this.index < this.elements.size()) {
            Follow follow = this.elements.get(this.index++);
            follow.doExecute(rtm, ruleData, this);
        }
    }
}
