package com.ycourlee.explore.bootprocess.org.springframework.transaction.support;

import com.ycourlee.explore.basic.dao.MovieMapper;
import com.ycourlee.explore.basic.dao.model.Movie;
import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yongjiang
 * @date 2022.02.09
 */
public class TransactionSynchronizationManagerTest extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(TransactionSynchronizationManagerTest.class);

    private static final Movie movie = Movie.builder().name("asiohgqws").build();

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private Tx          tx;

    @Test
    public void printCglibProxyTest() {
        Class<? extends Tx> cglibProxyClass = tx.getClass();
        log.info("cglibProxyClass.getName(): {}", cglibProxyClass.getName());
        log.info("cglibProxyClass.getSimpleName(): {}", cglibProxyClass.getSimpleName());
        for (Method method : cglibProxyClass.getMethods()) {
            log.info("method.getName(): {}", method.getName());
        }
    }

    /**
     * 方法调用 内部且标注了transactional的私有方法 注解不生效，不会打开事务
     */
    @Test
    public void nonProxyMethodInternallyInvokingAnnotatedTransactionalMethodTest() {
        tx.nonProxyMethodInternallyInvokingAnnotatedTransactionalMethod(movie);
    }

    /**
     * 从AopContext获取当前代理类
     */
    @Test
    public void proxyMethodInternallyInvokingAnnotatedTransactionalMethodTest() {
        tx.proxyMethodInternallyInvokingAnnotatedTransactionalMethod(movie);
    }

    /**
     * 代理方法是事务，默认的隔离级别是可重复度，事务所做的修改在其未提交前对其他事务不可见
     */
    @Test
    public void correctTranTest() {
        tx.correctTran(movie);
        log.info("movie: {}", movie);
    }

    @Test
    public void mainTest() {
        Movie temp = new Movie();
        try {
            tx.errorTran(temp);
        } catch (Exception e) {
        }
        // will roll back
        log.info("id: {}", temp.getId());
        Movie movie = movieMapper.selectByPrimaryKey(temp.getId());
        assertNull(movie);
    }

    @Test
    public void main2Test() {

        LocalDateTime of = LocalDateTime.of(2022, 1, 15, 10, 39, 23, 9999999);

        Movie movie = Movie.builder().name("asdf").createTime(toDate(of)).build();
        int i = movieMapper.insertSelective(movie);
        assertTrue(i > 0);
    }


    /**
     * TransactionSynchronizationManager拥有属性synchronizations，是线程变量，是有序的，是LinkedHashSet
     * 维护所在事务的所有TransactionSynchronization。
     * TransactionSynchronization执行顺序：
     * 代理方法执行时，如果执行到了TransactionSynchronizationManager.registerSynchronization（若其不在事务中，或不能被事务传播到，会出现异常），
     * 则将相应的TransactionSynchronization进行注册，接着执行后面的代码，执行到一个事务方法尾时，才会执行该事务方法内所有注册的TransactionSynchronization
     */
    @Test
    public void transactionSynchronizationExecutionSequenceTest() {

        tx.correctOptTranWithTransactionRegister(new Movie());
        /*
         * 输出内容为
         * opt(movieArg): 6
         * beforeCommit2 opt(movieArg): 7
         * beforeCommit opt(movieArg): 8
         * */
    }
}
