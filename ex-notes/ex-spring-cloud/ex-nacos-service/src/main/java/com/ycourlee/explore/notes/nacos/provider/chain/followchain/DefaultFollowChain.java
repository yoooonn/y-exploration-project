package com.ycourlee.explore.notes.nacos.provider.chain.followchain;

import com.ycourlee.explore.notes.nacos.provider.chain.AbstractElementChain;
import com.ycourlee.tranquil.web.dto.Response;

import java.util.List;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
public class DefaultFollowChain extends AbstractElementChain<Response, RuleData, Follow> implements FollowChain {

    public DefaultFollowChain(List<Follow> follows) {
        super(follows);
    }

    @Override
    public void doExecute(Response resp, RuleData ruleData) {
        if (this.index < this.elements.size()) {
            Follow follow = this.elements.get(this.index++);
            follow.doExecute(resp, ruleData, this);
        }
    }
}
