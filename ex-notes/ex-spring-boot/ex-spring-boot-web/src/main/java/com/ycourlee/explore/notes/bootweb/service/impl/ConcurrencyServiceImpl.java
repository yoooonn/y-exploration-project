package com.ycourlee.explore.notes.bootweb.service.impl;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.notes.bootweb.service.ConcurrencyService;
import com.ycourlee.tranquil.redisson.annotation.Lockable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yooonn
 * @date 2022.06.23
 */
@Service
public class ConcurrencyServiceImpl implements ConcurrencyService {

    @Autowired
    private ActorMapper actorMapper;

    @Lockable(value = "add:age:{{uid}}", waitTime = 2)
    public void addAge(Long uid) throws InterruptedException {
        Actor actor = actorMapper.selectByPrimaryKey(uid);
        actor.setAge(actor.getAge() + 1);
        Thread.sleep(ThreadLocalRandom.current().nextLong(30));
        actorMapper.updateByPrimaryKeySelective(actor);
    }

    public void addAgeNoLock(Long uid) throws InterruptedException {
        Actor actor = actorMapper.selectByPrimaryKey(uid);
        actor.setAge(actor.getAge() + 1);
        Thread.sleep(ThreadLocalRandom.current().nextLong(30));
        actorMapper.updateByPrimaryKeySelective(actor);
    }
}
