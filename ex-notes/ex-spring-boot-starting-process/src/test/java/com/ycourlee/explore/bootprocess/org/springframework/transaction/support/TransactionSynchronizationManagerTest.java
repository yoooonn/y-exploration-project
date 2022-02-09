package com.ycourlee.explore.bootprocess.org.springframework.transaction.support;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.ActorMovieMapper;
import com.ycourlee.explore.basic.dao.MovieMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.basic.dao.model.Movie;
import com.ycourlee.explore.bootprocess.SpringTestEnv;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author yongjiang
 * @date 2022.02.09
 */
public class TransactionSynchronizationManagerTest extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(TransactionSynchronizationManagerTest.class);

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private ActorMovieMapper actorMovieMapper;

    @Test
    public void mainTest() {
        Long id = null;
        try {
            id = errorTran1();
        } catch (Exception e) {
        }
        log.info("id: {}", id);
        Movie movie = movieMapper.selectByPrimaryKey(id);
        assertNull(movie);
    }

    @Transactional(rollbackFor = Exception.class)
    public Long errorTran1() {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        actorMapper.insert(Actor.builder().name("hello").build());
        return movie.getId();
    }
}
