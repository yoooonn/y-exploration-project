package com.ycourlee.explore.bootprocess.chain.followchain;

import com.ycourlee.tranquil.web.dto.Response;
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
    public void doExecute(Response resp, RuleData ruleData) {
        new DefaultFollowChain(follows).doExecute(resp, ruleData);
    }
}
