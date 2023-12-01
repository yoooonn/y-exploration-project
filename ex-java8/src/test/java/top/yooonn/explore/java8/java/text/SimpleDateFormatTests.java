package top.yooonn.explore.java8.java.text;

import top.yooonn.explore.java8.AbstractTest;
import lombok.SneakyThrows;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yooonn
 * @date 2022.03.21
 */
public class SimpleDateFormatTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(SimpleDateFormatTests.class);

    @Test
    @SneakyThrows
    public void mainTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("1898-03-04 12:13:56");
        log.info("date.getTime(): {}", date.getTime());
        Date date1 = new Date(Long.MIN_VALUE);
        log.info("dateFormat.format(date1): {}", dateFormat.format(date1));
        log.info("date1.getTime(): {}", date1.getTime());
        System.out.println(dateFormat.format(dateFormat.parse("2022-4-13 2:00:00")));
    }
}
