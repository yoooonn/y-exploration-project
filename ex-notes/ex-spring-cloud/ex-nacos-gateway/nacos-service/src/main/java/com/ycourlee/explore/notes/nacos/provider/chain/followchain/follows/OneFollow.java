package com.ycourlee.explore.notes.nacos.provider.chain.followchain.follows;

import com.ycourlee.explore.notes.nacos.provider.chain.followchain.Follow;
import com.ycourlee.explore.notes.nacos.provider.chain.followchain.FollowChain;
import com.ycourlee.explore.notes.nacos.provider.chain.followchain.RuleData;
import com.ycourlee.explore.notes.nacos.provider.service.GenericService;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.12.09
 */
@Component
public class OneFollow implements Follow {

    @Autowired
    private GenericService genericService;

    @Override
    public boolean disabled() {
        return true;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void doExecute(Response resp, RuleData ruleData, FollowChain chain) {
        System.out.println("genericService = " + genericService);
    }
}
