package com.ycourlee.explore.bootprocess.annotation;

import org.springframework.boot.logging.LogLevel;

import java.lang.annotation.*;

/**
 * @author yongjiang
 * @date 2022.03.23
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeCostLogger {

    LogLevel logLevel() default LogLevel.TRACE;

    /**
     * 超过阈值是否告警（log.warn）
     * @return
     */
    boolean warn() default false;

    /**
     * 告警阈值，纳秒数
     * @return warnThreshold
     */
    int warnThreshold() default 100;
}
