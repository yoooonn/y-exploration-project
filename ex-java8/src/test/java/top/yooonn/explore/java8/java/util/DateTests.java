package top.yooonn.explore.java8.java.util;

import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yooonn
 * @date 2022.03.28
 */
public class DateTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(DateTests.class);

    @Test
    public void mainTest() {
        Date date = new Date(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        log.info("dateString: {}", dateString);
    }
}
