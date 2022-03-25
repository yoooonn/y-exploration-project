package com.ycourlee.explore.bootprocess.watcher;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yongjiang
 * @date 2022.01.24
 */
public class TransactionalWatcherTest extends BootProcessApplicationTests {

    @Autowired
    private TransactionalWatcher transactionalWatcher;

    @Test
    public void mainTest() {
        transactionalWatcher.transaction1();
    }
}
