package com.ycourlee.explore.javalib.cn.hutool.core.date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.ycourlee.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.12.08
 */
public class DateUtilTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(DateUtilTests.class);

    @Test
    void parseTest() {
        DateTime time = DateUtil.parse("2022-12-07");
        System.out.println(DateUtil.format(time, DatePattern.NORM_DATETIME_PATTERN));
    }
}
