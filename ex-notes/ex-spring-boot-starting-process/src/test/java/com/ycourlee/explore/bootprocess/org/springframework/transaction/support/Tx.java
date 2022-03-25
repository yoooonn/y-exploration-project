package com.ycourlee.explore.bootprocess.org.springframework.transaction.support;

import com.ycourlee.explore.basic.dao.ActorMapper;
import com.ycourlee.explore.basic.dao.MovieMapper;
import com.ycourlee.explore.basic.dao.model.Actor;
import com.ycourlee.explore.basic.dao.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("UnusedReturnValue")
@Component
public class Tx {

    private static final Logger log = LoggerFactory.getLogger(Tx.class);

    @Autowired
    private MovieMapper      movieMapper;
    @Autowired
    private ActorMapper      actorMapper;

    @Transactional(rollbackFor = Exception.class)
    public void errorTran(Movie movieArg) {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        actorMapper.insertSelective(Actor.builder().name("hello").build());
        movieArg.setId(movie.getId());
        throw new IllegalStateException();
        // return movie.getId();
    }

    public Long proxyMethodInternallyInvokingAnnotatedTransactionalMethod(Movie movieArg) {
        return ((Tx) AopContext.currentProxy()).AnnotatedTransactionalMethod(movieArg);
    }

    public Long nonProxyMethodInternallyInvokingAnnotatedTransactionalMethod(Movie movieArg) {
        return AnnotatedTransactionalMethod(movieArg);
    }

    @Transactional(rollbackFor = Exception.class)
    public Long AnnotatedTransactionalMethod(Movie movieArg) {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        actorMapper.insertSelective(Actor.builder().name("hello").build());
        movieArg.setId(movie.getId());
        return movie.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public Long correctTran(Movie movieArg) {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        actorMapper.insertSelective(Actor.builder().name("hello").build());
        movieArg.setId(movie.getId());
        return movie.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void correctOptTranWithTransactionRegister(Movie movieArg) {
        log.info("opt(movieArg): {}", insertData(movieArg));
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void beforeCommit(boolean readOnly) {
                log.info("beforeCommit2 opt(movieArg): {}", insertData(movieArg));
            }
            @Override
            public void afterCommit() {
                Movie x = movieMapper.selectByPrimaryKey(movieArg.getId());
                assertNotNull(x);
            }

            @Override
            public void beforeCompletion() {
                TransactionSynchronization.super.beforeCompletion();
                log.info("beforeCompletion");
            }

            @Override
            public void afterCompletion(int status) {
                TransactionSynchronization.super.afterCompletion(status);
                log.info("afterCompletion");
            }

            @Override
            public void suspend() {
                TransactionSynchronization.super.suspend();
                log.info("suspend");
            }

            @Override
            public void resume() {
                TransactionSynchronization.super.resume();
                log.info("resume");
            }

            @Override
            public void flush() {
                TransactionSynchronization.super.flush();
                log.info("flush");
            }
        });
        correctOpt(movieArg);
    }


    public void correctOpt(Movie movieArg) {
        log.info("opt2(movieArg): {}", insertData(movieArg));
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void beforeCommit(boolean readOnly) {
                log.info("beforeCommit opt(movieArg): {}", insertData(movieArg));
            }

            @Override
            public void afterCommit() {
                Movie x = movieMapper.selectByPrimaryKey(movieArg.getId());
                assertNotNull(x);
            }
        });

        log.info("opt3(movieArg): {}", insertData(movieArg));
    }

    public Long insertData(Movie movieArg) {
        Movie movie = Movie.builder().name("a").build();
        movieMapper.insertSelective(movie);
        movieArg.setId(movie.getId());
        return movie.getId();
    }
}
