package com.ycourlee.explore.bootprocess.org.springframework.boot.convert;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yongjiang
 * @date 2022.01.06
 */
public class ApplicationConversionServiceTest extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ApplicationConversionServiceTest.class);

    @Test
    public void mainTest() {
        ConversionService conversionService = beanFactory.getConversionService();
        Assert.notNull(conversionService);
        log.info("conversionService.canConvert(Date.class, LocalDateTime.class) = {}", conversionService.canConvert(Date.class, LocalDateTime.class));
        log.info("conversionService.canConvert(Date.class, LocalDate.class) = {}", conversionService.canConvert(Date.class, LocalDate.class));
        log.info("conversionService.canConvert(int.class, Long.class) = {}", conversionService.canConvert(int.class, Long.class));
        log.info("conversionService.canConvert(Date.class, Long.class) = {}", conversionService.canConvert(Date.class, Long.class));
    }
}
