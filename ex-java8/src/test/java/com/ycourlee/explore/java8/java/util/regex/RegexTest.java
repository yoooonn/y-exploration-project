package com.ycourlee.explore.java8.java.util.regex;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yooonn
 * @date 2022.01.06
 */
public class RegexTest extends AbstractTest {


    private static final Logger log = LoggerFactory.getLogger(RegexTest.class);

    @Test
    public void mainTest() {
        Pattern pattern = Pattern.compile("(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)");
        Matcher matcher = pattern.matcher("34122220000431123X");
        log.info("matcher.matches() = {}", matcher.matches());
    }
}
