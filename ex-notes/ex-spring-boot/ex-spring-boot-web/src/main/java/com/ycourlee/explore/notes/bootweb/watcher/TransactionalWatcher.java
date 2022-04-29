package com.ycourlee.explore.notes.bootweb.watcher;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.notes.bootweb.context.ApplicationEventPublisherHolder;
import com.ycourlee.explore.notes.bootweb.event.SimpleTransactionalEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yongjiang
 * @date 2022.01.24
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class TransactionalWatcher extends ApplicationEventPublisherHolder {

    @Autowired
    private ActorMapper actorMapper;

    public void transaction1() {
        actorMapper.insertSelective(Actor.builder().name("hello").build());
        Actor actor = actorMapper.selectByPrimaryKey(12L);
        actorMapper.updateByPrimaryKeySelective(Actor.builder().id(1000L).name("modified").build());
        publisher.publishEvent(new SimpleTransactionalEvent("yaya"));
    }
}
