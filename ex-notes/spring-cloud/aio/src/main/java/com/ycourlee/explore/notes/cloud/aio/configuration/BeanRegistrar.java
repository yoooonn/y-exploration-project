package com.ycourlee.explore.notes.cloud.aio.configuration;

import com.ycourlee.explore.notes.cloud.aio.watchpoint.impl.InjectedWatchPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yooonn
 * @date 2023.01.09
 */
@Configuration(proxyBeanMethods = false)
public class BeanRegistrar {

    @Configuration(proxyBeanMethods = false)
    static class InjectedWatchPointConf {

        @Bean
        public InjectedWatchPoint.Hello hello() {
            return new InjectedWatchPoint.Hello();
        }

        @Bean
        public InjectedWatchPoint.World world() {
            return new InjectedWatchPoint.World();
        }
    }
}
