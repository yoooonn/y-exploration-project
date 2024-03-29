package top.yooonn.explore.notes.bootweb.watcher;

import top.yooonn.explore.notes.bootweb.BootProcessApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yooonn
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
