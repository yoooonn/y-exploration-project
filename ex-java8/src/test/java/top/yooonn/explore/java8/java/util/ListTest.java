package top.yooonn.explore.java8.java.util;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yooonn
 * @date 2021.12.14
 */
public class ListTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void errorSortTest() {
        Date date = new Date();
        Date date1 = timeOf(date, 10);
        Date date2 = timeOf(date, 10);
        log.info("dateFormat(date): {}", dateFormat(date));
        log.info("dateFormat(date1): {}", dateFormat(date1));
        log.info("dateFormat(date2): {}", dateFormat(date2));
        List<Long> dates = Arrays.asList(date.getTime(), date1.getTime(), date2.getTime());
        dates.sort((d1, d2) -> ((int) (d2 - d1)));
    }

    @Test
    public void chineseCharacterSortTest() {
        List<String> strings = Arrays.asList("波", "涌", "的", "次", "啊", "得");
        strings.sort(String::compareTo);
        strings.forEach(System.out::println);
        strings.forEach(s -> System.out.println());
    }
}
