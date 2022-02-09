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
        Movie temp = new Movie();;
        try {
            errorTran1(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("id: {}", temp.getId());
        Movie movie = movieMapper.selectByPrimaryKey(temp.getId());
        assertNull(movie);
    }

    @Transactional(rollbackFor = Exception.class)
    public Long errorTran1(Movie movieArg) {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        actorMapper.insertSelective(Actor.builder().name("hello").build());
        int i = 12 / 0;
        movieArg.setId(movie.getId());
        return movie.getId();
    }
}
