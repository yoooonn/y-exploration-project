package top.yooonn.explore.javalib.com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import top.yooonn.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.03.26
 */
public class TableTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(TableTests.class);

    @Test
    void mainTest() {
        Table<Integer, Integer, String> table = ImmutableTable.<Integer, Integer, String>builder().build();
        int index = 1;
        // noinspection ConstantConditions
        int i = (index / 3) * 3;
        // noinspection ConstantConditions
        int j = (index % 3 - 1) * 3;

        log.info("{}{}\n", i, j);
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                log.info("{}{}", k, l);
            }
        }
    }
}
