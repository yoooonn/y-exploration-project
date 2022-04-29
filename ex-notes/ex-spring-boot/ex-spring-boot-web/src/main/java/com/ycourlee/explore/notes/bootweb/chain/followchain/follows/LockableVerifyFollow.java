package com.ycourlee.explore.notes.bootweb.chain.followchain.follows;

import com.ycourlee.explore.notes.bootweb.chain.followchain.Follow;
import com.ycourlee.explore.notes.bootweb.chain.followchain.FollowChain;
import com.ycourlee.explore.notes.bootweb.chain.followchain.RuleData;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.12.09
 */
@Component
public class LockableVerifyFollow implements Follow {

    @Override
    public boolean disabled() {
        return false;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void doExecute(Response resp, RuleData ruleData, FollowChain chain) {

    }
}
