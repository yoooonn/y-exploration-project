package com.ycourlee.explore.notes.bootweb.listener.annotationbased;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.notes.bootweb.event.SimpleTransactionalEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author yooonn
 * @date 2022.01.22
 */
@Component
public class TransactionalViewListener {

    private static final Logger log = LoggerFactory.getLogger(TransactionalViewListener.class);

    @Autowired
    private ActorMapper actorMapper;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void subscribeSimpleTransactionalEvent(SimpleTransactionalEvent event) {
        log.debug("event.getSource(): {}", event.getSource());
        actorMapper.updateByPrimaryKeySelective(Actor.builder().id(1L).name("modified").build());
    }
}
