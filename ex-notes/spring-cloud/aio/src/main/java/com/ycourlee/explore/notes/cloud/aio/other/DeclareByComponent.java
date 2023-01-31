package com.ycourlee.explore.notes.cloud.aio.other;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

/**
 * @author yooonn
 * @date 2022.12.30
 */
// @Component
@RequiredArgsConstructor
public class DeclareByComponent implements SmartInitializingSingleton {

    private final BeanFactory beanFactory;

    @Bean
    public B b() {
        return new B().setA(a());
    }

    @Bean
    public A a() {
        return new A();
    }

    @Override
    public void afterSingletonsInstantiated() {
        B b = beanFactory.getBean(B.class);
        A a = beanFactory.getBean(A.class);
        Assert.state(b.getA() != a, "must be diff instance");
    }
}
