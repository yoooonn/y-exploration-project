package com.ycourlee.explore.bootprocess.aspect;

import com.ycourlee.explore.bootprocess.annotation.TimeCostLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2022.03.23
 */
@Aspect
@Component
public class AppsAspect {

    @Around(value = "@annotation(timeCostLogger)", argNames = "joinPoint,timeCostLogger")
    public Object timeCostLogger(ProceedingJoinPoint joinPoint, TimeCostLogger timeCostLogger) {
        long begin = System.nanoTime();
        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("proceed error when aspect executed", e);
        }
        long end = System.nanoTime();
        long costInNanoseconds = end - begin;
        String output = String.format("%s cost %s nanoseconds", joinPoint.getSignature().toShortString(), costInNanoseconds);
        switch (timeCostLogger.logLevel()) {
            case OFF:
            case ERROR:
                PlainTimeCostLogger.log.error(output);
            case WARN:
                PlainTimeCostLogger.log.warn(output);
            case INFO:
                PlainTimeCostLogger.log.info(output);
            case DEBUG:
                PlainTimeCostLogger.log.debug(output);
            case TRACE:
                PlainTimeCostLogger.log.trace(output);
            default:
        }
        if (timeCostLogger.warn() && costInNanoseconds > timeCostLogger.warnThreshold()) {
            PlainTimeCostLogger.log.warn("{} takes too long time to execute.", joinPoint.getSignature().toShortString());
        }
        return proceed;
    }

    static class PlainTimeCostLogger {

        static final Logger log = LoggerFactory.getLogger(PlainTimeCostLogger.class);
    }
}
