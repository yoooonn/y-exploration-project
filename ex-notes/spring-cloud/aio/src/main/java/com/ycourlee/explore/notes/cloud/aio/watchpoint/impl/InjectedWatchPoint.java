package com.ycourlee.explore.notes.cloud.aio.watchpoint.impl;

import com.ycourlee.explore.notes.cloud.aio.watchpoint.Context;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPoint;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yooonn
 * @date 2022.12.13
 */
@Component
@RequiredArgsConstructor
public class InjectedWatchPoint implements WatchPoint {

    private static final Logger log = LoggerFactory.getLogger(InjectedWatchPoint.class);
    @Resource
    private              Foo    hello;

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        hello.perform();
        chain.doExecute(response, context);
    }

    /**
     * @author yooonn
     * @date 2023.01.09
     */
    public interface Foo {

        void perform();
    }

    /**
     * @author yooonn
     * @date 2023.01.09
     */
    public static class Hello implements Foo {

        private static final Logger log = LoggerFactory.getLogger(Hello.class);

        @Override
        public void perform() {
            log.warn("hello");
        }
    }

    /**
     * @author yooonn
     * @date 2023.01.09
     */
    public static class World implements Foo {

        private static final Logger log = LoggerFactory.getLogger(World.class);

        @Override
        public void perform() {
            log.warn("World!");
        }
    }
}
