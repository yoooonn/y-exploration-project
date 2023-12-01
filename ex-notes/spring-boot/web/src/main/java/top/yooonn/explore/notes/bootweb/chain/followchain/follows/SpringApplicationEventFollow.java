package top.yooonn.explore.notes.bootweb.chain.followchain.follows;

import top.yooonn.explore.notes.bootweb.chain.followchain.Follow;
import top.yooonn.explore.notes.bootweb.chain.followchain.FollowChain;
import top.yooonn.explore.notes.bootweb.chain.followchain.RuleData;
import top.yooonn.explore.notes.bootweb.event.SimpleEvent;
import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
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
