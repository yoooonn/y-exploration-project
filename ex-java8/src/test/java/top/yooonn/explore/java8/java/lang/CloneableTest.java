package top.yooonn.explore.java8.java.lang;

import com.google.common.collect.Lists;
import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yooonn
 * @date 2023.01.13
 */
public class CloneableTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(CloneableTest.class);

    @Test
    public void mainTest() {
        List<Integer> a = Lists.newArrayList(1, 3, 5);
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>(a));
        a.remove(((Object) 3));
        l.add(new ArrayList<>(a));
        log.info("{}", l);
    }
}
