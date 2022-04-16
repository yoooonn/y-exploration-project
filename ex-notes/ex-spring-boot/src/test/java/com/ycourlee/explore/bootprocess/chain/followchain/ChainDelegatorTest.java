package com.ycourlee.explore.bootprocess.chain.followchain;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import com.ycourlee.root.core.domain.context.Rtm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yongjiang
 * @date 2021.11.30
 */
public class ChainDelegatorTest extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ChainDelegatorTest.class);

    @Autowired
    private ChainDelegator chainDelegator;

    @Test
    void doDefaultFollowChainTest() {
        Rtm rtm = Rtm.success();
        chainDelegator.doExecute(rtm, new RuleData());
        log.info("rtm: {}", rtm);
        Assertions.assertNotNull(rtm.get("data"));
    }
}
